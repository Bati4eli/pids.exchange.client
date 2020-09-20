package ru.bati4eli.pids.exchange.client.services

//import javax.comm.CommPort
//import javax.comm.SerialPort.*
import jssc.*
import ru.bati4eli.pids.exchange.client.app.FxApplication
import ru.bati4eli.pids.exchange.client.app.FxGuiController

import static ru.bati4eli.pids.exchange.client.log.MyLog.log

class SerialPortService {

    private FxGuiController controller
    private SerialPort serialPort
    private String currentPortName

    SerialPortService(FxApplication application) {
        this.controller = application.controller
        controller.serialPortService = this
        researchPorts()
        connect(controller.port)
    }

    void researchPorts() {
        def names = SerialPortList.getPortNames() as List<String>
        controller.choiceBox.with {
            it.items.removeAll()
            it.items.addAll(names)
            it.value = names.last()
        }
    }

    void connect(String port) {
        //Передаём в конструктор имя порта
        serialPort = new SerialPort(port)
        currentPortName = port
        try {
            log.debug(".. Connection to $port")
            controller.appendToHistory(".. Connection to $port")

            serialPort.openPort()//Открываем порт //todo тобi писта здесь!

            serialPort.setParams(SerialPort.BAUDRATE_9600, //Выставляем параметры
                    SerialPort.DATABITS_8,
                    SerialPort.STOPBITS_1,
                    SerialPort.PARITY_NONE)
            //Включаем аппаратное управление потоком
            serialPort.setFlowControlMode(SerialPort.FLOWCONTROL_RTSCTS_IN |
                    SerialPort.FLOWCONTROL_RTSCTS_OUT)

            serialPort.addEventListener(new PortReader(), SerialPort.MASK_RXCHAR) //Устанавливаем ивент лисенер и маску



        } catch (Throwable ex) {
            log.error(ex)
        }
    }

    private class PortReader implements SerialPortEventListener {
        @Override
        void serialEvent(SerialPortEvent event) {
            if (event.isRXCHAR() && event.getEventValue() > 0) {
                try {
                    //Получаем ответ от устройства, обрабатываем данные и т.д.
                    String data = serialPort.readString(event.getEventValue())
                    controller.appendToHistory(currentPortName, data)
                    // снова отправляем запрос
                } catch (SerialPortException ex) {
                    log.error(ex)
                }
            }
        }
    }

    void sendData(String data) {
        serialPort.writeString(data)
        controller.appendToHistory('ME', data)
    }


}

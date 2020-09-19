package ru.bati4eli.pids.exchange.client.comPort

import jssc.SerialPort
import jssc.SerialPortEvent
import jssc.SerialPortEventListener
import jssc.SerialPortException

class ExampleSerialPortConversation {

    private static SerialPort serialPort

    static void main(String[] args) {
        //Передаём в конструктор имя порта
        serialPort = new SerialPort("COM1")

        try {
            //Открываем порт
            serialPort.openPort()
            //Выставляем параметры
            serialPort.setParams(SerialPort.BAUDRATE_9600,
                    SerialPort.DATABITS_8,
                    SerialPort.STOPBITS_1,
                    SerialPort.PARITY_NONE)
            //Включаем аппаратное управление потоком
            serialPort.setFlowControlMode(SerialPort.FLOWCONTROL_RTSCTS_IN |
                    SerialPort.FLOWCONTROL_RTSCTS_OUT)
            //Устанавливаем ивент лисенер и маску
            serialPort.addEventListener(new PortReader(), SerialPort.MASK_RXCHAR)
            //Отправляем запрос устройству
            serialPort.writeString("Get data")
        } catch (SerialPortException ex) {
            System.out.println(ex)
        }
    }

    private static class PortReader implements SerialPortEventListener {
        @Override
        void serialEvent(SerialPortEvent event) {
            if (event.isRXCHAR() && event.getEventValue() > 0) {
                try {
                    //Получаем ответ от устройства, обрабатываем данные и т.д.
                    String data = serialPort.readString(event.getEventValue())
                    // снова отправляем запрос
                    serialPort.writeString("Get data")
                } catch (SerialPortException ex) {
                    System.out.println(ex)
                }
            }
        }
    }
}

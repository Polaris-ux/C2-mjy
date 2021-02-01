import java.util.ArrayList;
import java.util.List;

/**
 * @author
 * @Description
 * @create 2021-02-01-11:17
 */
public class Task9 {
    public static void main(String[] args) {
        Computer computer = new Computer();
        Mouse mouse = new Mouse();
        KeyBoard keyBoard = new KeyBoard();
        Microphone microphone = new Microphone();
        computer.addUSB(mouse);
        computer.addUSB(keyBoard);
        computer.addUSB(microphone);
        System.out.println("------------------------");
        computer.powerOn();
        System.out.println("------------------------");
        computer.powerOff();
    }
}

interface USB {
    void start();

    void close();
}

class Mouse implements USB {

    @Override
    public void start() {
        System.out.println("鼠标启动了");
    }

    @Override
    public void close() {
        System.out.println("鼠标关闭了");
    }
}

class KeyBoard implements USB {
    @Override
    public void start() {
        System.out.println("键盘启动了");
    }

    @Override
    public void close() {
        System.out.println("键盘关闭了");
    }
}

class Microphone implements USB {
    @Override
    public void start() {
        System.out.println("麦克风启动了");
    }

    @Override
    public void close() {
        System.out.println("麦克风关闭了");
    }
}

class Computer {
    private List<USB> list = new ArrayList<>();

    public void addUSB(USB usb) {
        list.add(usb);
        loadUSB(usb);
    }

    //安装设备驱动
    private void loadUSB(USB usb) {
        String usbName = null;
        if (usb instanceof Mouse) {
            usbName = "鼠标";
        } else if (usb instanceof KeyBoard) {
            usbName = "键盘";
        } else if (usb instanceof Microphone) {
            usbName = "麦克风";
        }

        System.out.println("正在安装" + usbName + "USB设备");
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(usbName + "安装完毕！");
    }

    public void powerOn() {
        for (int i = 0; i < list.size(); i++) {
            USB usb = list.get(i);
            usb.start();
        }
        System.out.println("电脑启动");
    }

    public void powerOff() {
        for (int i = 0; i < list.size(); i++) {
            USB usb = list.get(i);
            usb.close();
        }
        System.out.println("电脑关闭！！");
    }
}

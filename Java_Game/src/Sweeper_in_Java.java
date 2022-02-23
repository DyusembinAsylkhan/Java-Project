import javax.swing.*;
//Подключаю графическую библиотеку.
public class Sweeper_in_Java extends JFrame
//Теперь методы, поля, свойства, события класса JFrame будут доступны из нашего класса Sweeper_in_Java.
{
    public static void main(String[] args)
    {
        new Sweeper_in_Java();

    }

    private Sweeper_in_Java()
    //Создаю приватный конструктор, потому как он будет применятся только отсюда и статус Public ему не требуется
    {
        initialization_Frame();
    }

    private void initialization_Frame()
    //Для запуска фрейма подготовлю дополнительные команды, которые объединю в этой функции
    {
        pack(); //Вызываю функцию Pack, чтобы изменять размер формы
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        /*Теперь программа будет выключаться, после нажатия на крестик.
        Я имею ввиду, что до этой функции и конкретно этой константы, программа продолжала работать
        даже после выключения. А теперь нет))*/
        setTitle("MineSweeper by students"); //Устанавливаю заголовок.
        setLocationRelativeTo(null); //Располагаю окно по центру.
        setResizable(false);//Функция для ограничения размеров окна.
        setVisible(true);
        /*Создаю экземпляр программы, чтобы можно было увидеть JFrame.
             Значение "True" позволяет JFrame быть визуально видимым.
               Теперь сверху слева появляется интерфейс будущей игры*/
    }
}

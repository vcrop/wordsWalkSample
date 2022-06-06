package ru.vcrop;

import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Finder finder = new Finder();

        //Буквы отсюда =>
        //https://fsd.kopilkaurokov.ru/up/html/2017/01/31/k_589096e04c628/img_user_file_589096e105e3c_1.jpg

        System.out.println(
                Set.copyOf(
                        finder.find(
                                new String[][]{
                                        "ясосьминог".split(""),
                                        "дронкетьщу".split(""),
                                        "езгмахлурс".split(""),
                                        "лошерскраб".split(""),
                                        "ьпидпарска".split(""),
                                        "фокунькюйн".split(""),
                                        "илазвиеутв".split(""),
                                        "нждатьмоль".split(""),
                                        "юькарасьыа".split(""),
                                        "чепясельдь".split("")
                                }
                        )
                )
        );
    }

}

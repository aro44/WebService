package example;

import javax.xml.ws.Endpoint;
import java.util.Scanner;

public class WebServicePublish {
    public static void main(String[] args) {
        // 创建 TaxCalculatorImpl 实例并发布 Web 服务
        TaxCalculatorImpl calculator = new TaxCalculatorImpl();
        Endpoint.publish("http://localhost:8080/tax", calculator);
        System.out.println("Web服务已成功发布！");

        // 控制台输入和输出部分
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入您的收入金额（输入 -1 退出）：");

        while (true) {
            try {
                double income = scanner.nextDouble();
                if (income == -1) {
                    System.out.println("退出程序。");
                    break;
                }
                // 使用 calculator 计算税额
                double tax = calculator.calculateTax(income);
                System.out.printf("您应缴纳的税额为：%.2f%n", tax);
            } catch (Exception e) {
                System.out.println("输入无效，请输入有效的收入金额数字：");
                scanner.next(); // 清除无效输入
            }
        }
        scanner.close(); // 关闭 scanner
    }
}

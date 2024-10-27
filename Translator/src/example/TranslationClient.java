package example;

import java.util.Scanner;

public class TranslationClient {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SOAPRequestHandler soapRequestHandler = new SOAPRequestHandler();
        Translator translator = new Translator(soapRequestHandler);
        SentenceTranslator sentenceTranslator = new SentenceTranslator(soapRequestHandler);
        RelatedTermsFetcher relatedTermsFetcher = new RelatedTermsFetcher(soapRequestHandler);

        while (true) {
            System.out.println("请选择翻译方式:");
            System.out.println("1. 单词翻译");
            System.out.println("2. 句子翻译");
            System.out.println("3. 相关词条查询");
            System.out.println("4. 退出");
            System.out.print("请输入选项（1-4）：");

            int choice = scanner.nextInt();
            scanner.nextLine();  // 消耗换行符

            switch (choice) {
                case 1:
                    System.out.print("请输入要翻译的单词: ");
                    String wordToTranslate = scanner.nextLine();
                    String translation = translator.translate(wordToTranslate);
                    System.out.println("翻译结果: " + translation);
                    break;
                case 2:
                    System.out.print("请输入要翻译的句子: ");
                    String sentenceToTranslate = scanner.nextLine();
                    String sentenceTranslation = sentenceTranslator.translateSentence(sentenceToTranslate);
                    System.out.println("翻译结果: " + sentenceTranslation);
                    break;
                case 3:
                    System.out.print("请输入要查询的中文单词: ");
                    String relatedWord = scanner.nextLine();
                    String relatedTerms = relatedTermsFetcher.getRelatedTerms(relatedWord);
                    System.out.println("相关词条: " + relatedTerms);
                    break;
                case 4:
                    System.out.println("退出程序。");
                    scanner.close();
                    return;
                default:
                    System.out.println("无效选项，请重新输入。");
            }
            System.out.println();
        }
    }
}
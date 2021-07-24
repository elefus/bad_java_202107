package com.bad_java.lectures._01;


import java.util.Arrays;
import java.util.Scanner;

/**
 * Учетная система библиотеки:
 *
 * Entity - Книга [ISBN, Title, Author, Year, Price]
 *
 * > ADD [ISBN, Title, Author, Year, Price] - Добавить книгу в каталог
 * > REMOVE [ISBN] - Удалить книгу из каталога
 * > PRINT - Вывести информацию обо всех книгах
 * > GET[ISBN] - Получить информацию о книге по ISBN
 * > GET_BY_AUTHOR [Author] Найти все книги (ISBN) определенного автора
 * > GET_BY_YEAR [Year] - Найти все книги (ISBN) определенного года издания
 * > GET_TOTAL_PRICE - Получить общую стоимость имеющихся книг
 * > EXIT
 *
 * ADD, 978-5-17-070645-7, Зов предков, Джек Лондон, 2011, 461.33
 * ADD, 978-5-389-08245-8, Обломов, Иван Гончаров, 2020, 350.5
 * ADD, 978-5-389-05507-0, Всадник без головы, Майн Рид, 2020, 520.7
 * ADD, 978-5-389-18955-3, Гроза, Александр Островский, 2019, 325.6
 */
public class LibraryERP {

  private static String[] isbns = {};
  private static String[] titles = {};
  private static String[] authors = {};
  private static int[] years = {};
  private static double[] prices = {};
  private static int countBooks = 0;

  public static void main(String[] args) {
    System.out.println("Program started!");

    Scanner in = new Scanner(System.in);
    String userInput;
    do {
      System.out.print("Input command: ");
      userInput = in.nextLine();

      String[] tokens = userInput.split(", ");
      String command = tokens[0].toUpperCase();
      switch (command) {
        case "ADD": {
          String isbn = tokens[1];
          addBook(isbn, tokens[2], tokens[3], Integer.parseInt(tokens[4]), Double.parseDouble(tokens[5]));
          break;
        }

        case "REMOVE": {
          String isbn = tokens[1];
          removeBook(isbn);
          break;
        }

        case "PRINT":
          printStorage();
          break;

        case "GET":
          getBookByIsbn(tokens[1]);
          break;

        case "GET_BY_AUTHOR":
          getBookByAuthor(tokens[1]);
          break;

        case "GET_BY_YEAR":
          getBookByYear(Integer.parseInt(tokens[1]));
          break;

        case "GET_TOTAL_PRICE":
          getTotalPrice();
          break;

        case "EXIT":
          break;

        default:
          System.err.println("Provided unknown command, please try again");
      }
    } while (!userInput.equalsIgnoreCase("exit"));
    System.out.println("Program finished!");
  }

  private static void getTotalPrice() {
    double totalPrice = 0;
    for (int i = 0; i < countBooks; i++) {
      totalPrice += prices[i];
    }
    System.out.println("Total price = " + totalPrice);
  }

  private static void getBookByYear(int year) {
    for (int i = 0; i < countBooks; i++) {
      if (years[i] == year) {
        System.out.println(String.join(", ", isbns[i], titles[i], authors[i], String.valueOf(years[i]), String.valueOf(prices[i])));
      }
    }
  }

  private static void getBookByAuthor(String author) {
    for (int i = 0; i < countBooks; i++) {
      if (authors[i].equals(author)) {
        System.out.println(String.join(", ", isbns[i], titles[i], authors[i], String.valueOf(years[i]), String.valueOf(prices[i])));
      }
    }
  }

  private static void getBookByIsbn(String isbn) {
    for (int i = 0; i < countBooks; i++) {
      if (isbns[i].equals(isbn)) {
        System.out.println(String.join(", ", isbns[i], titles[i], authors[i], String.valueOf(years[i]), String.valueOf(prices[i])));
      }
    }
  }

  private static void removeBook(String isbn) {
    int indexBookToRemove = -1;
    for (int i = 0; i < countBooks; i++) {
      if (isbns[i].equals(isbn)) {
        indexBookToRemove = i;
        break;
      }
    }

    assert indexBookToRemove >= 0;

//    if (indexBookToRemove < 0) {
//      System.out.println("No book to remove was found");
//      return;
//    }

    if (indexBookToRemove != countBooks - 1) {
      System.arraycopy(isbns, indexBookToRemove + 1, isbns, indexBookToRemove, countBooks - indexBookToRemove);
      System.arraycopy(titles, indexBookToRemove + 1, titles, indexBookToRemove, countBooks - indexBookToRemove);
      System.arraycopy(authors, indexBookToRemove + 1, authors, indexBookToRemove, countBooks - indexBookToRemove);
      System.arraycopy(years, indexBookToRemove + 1, years, indexBookToRemove, countBooks - indexBookToRemove);
      System.arraycopy(prices, indexBookToRemove + 1, prices, indexBookToRemove, countBooks - indexBookToRemove);
    }
    countBooks--;
  }

  private static void printStorage() {
    for (int i = 0; i < countBooks; i++) {
      System.out.println(String.join(", ", isbns[i], titles[i], authors[i], String.valueOf(years[i]), String.valueOf(prices[i])));
    }
  }

  public static void addBook(String isbn, String title, String author, int year, double price) {
    if (countBooks == isbns.length) {
      increaseStorageCapacity();
    }
    isbns[countBooks] = isbn;
    titles[countBooks] = title;
    authors[countBooks] = author;
    years[countBooks] = year;
    prices[countBooks] = price;
    ++countBooks;
  }

  private static void increaseStorageCapacity() {
    isbns = Arrays.copyOf(isbns, countBooks * 2 + 1);
    titles = Arrays.copyOf(titles, countBooks * 2 + 1);
    authors = Arrays.copyOf(authors, countBooks * 2 + 1);
    years = Arrays.copyOf(years, countBooks * 2 + 1);
    prices = Arrays.copyOf(prices, countBooks * 2 + 1);
  }
}

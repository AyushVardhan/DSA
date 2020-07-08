package com.Google.hashCode;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

class Library {
    long id;
    long booksAvaliable;
    long onboardingTime;
    long scanRate;
    List<Long> books;

    Library(long idLib, long books, long onboard, long scan, List<Long> bookList) {
        this.id = idLib;
        this.booksAvaliable = books;
        this.onboardingTime = onboard;
        this.scanRate = scan;
        this.books = bookList;
    }
}

public class GoogleBooks {
    static HashMap<Long, Long> books;

    public static void main(String[] args) throws IOException {
        File myObj = new File("/home/vardan/IdeaProjects/DSA/src/com/hashCode/in.txt");
        Scanner in = new Scanner(myObj);
        long[] firstLine = Arrays.stream(in.nextLine().trim().split(" ")).mapToLong(Long::parseLong).toArray();
        long bookCount = firstLine[0];
        long libraryCount = firstLine[1];
        long daysCount = firstLine[2];

        books = new HashMap<>();
        long[] booklistarray = Arrays.stream(in.nextLine().trim().split(" ")).mapToLong(Long::parseLong).toArray();
        for (int i = 0; i < booklistarray.length; i++) {
            books.put((long) i, booklistarray[i]);
        }

        List<Library> libraries = new ArrayList<>();
        for (int i = 0; i < libraryCount; i++) {
            long[] libraryDetails = Arrays.stream(in.nextLine().trim().split(" ")).mapToLong(Long::parseLong).toArray();
            long booksAvailable = libraryDetails[0];
            long onBoardTime = libraryDetails[1];
            long scanRate = libraryDetails[2];
            long[] bookDetails = Arrays.stream(in.nextLine().trim().split(" ")).mapToLong(Long::parseLong).toArray();
            List<Long> bookList = new ArrayList<>();
            for (int j = 0; j < bookDetails.length; j++) {
                bookList.add(bookDetails[j]);
            }
            libraries.add(new Library(i, booksAvailable, onBoardTime, scanRate, bookList));
        }

        long maxOnboardingDay = 0;
        for (Library library : libraries) {
            if (maxOnboardingDay < library.onboardingTime && library.onboardingTime < daysCount)
                maxOnboardingDay = library.onboardingTime;
        }

        //Considering day from which scan will start
        maxOnboardingDay = maxOnboardingDay + 1;

        HashMap<Long, Library> scoredLibrary = new HashMap<>();

        for (Library library : libraries) {
            if (library.onboardingTime < maxOnboardingDay) {
                long score = getLibraryScore(library, maxOnboardingDay);
                scoredLibrary.put(score, library);
            }
        }

        List<Map.Entry<Long, Library>> scoreSortedLibraries = new ArrayList<>(scoredLibrary.entrySet());
        scoreSortedLibraries.sort((e1, e2) -> e2.getKey().compareTo(e1.getKey()));

        System.out.println();
        for (Map.Entry<Long, Library> library : scoreSortedLibraries) {
            System.out.println("ID: " + library.getValue().id + " , BookCount: " + library.getValue().booksAvaliable);
        }

        System.out.println();
        FileWriter myWriter = new FileWriter("out.txt");
        System.out.println("Libraries Count :  " + scoreSortedLibraries.size());

        myWriter.write(String.valueOf(scoreSortedLibraries.size()));
        myWriter.write("\n");

        long daysLeft = daysCount;
        for (Map.Entry<Long, Library> library : scoreSortedLibraries) {
            Library currentLibrary = library.getValue();
            daysLeft = daysLeft - currentLibrary.onboardingTime;
            List<Long> bookScanOrder = getBooks(daysLeft, currentLibrary.books, currentLibrary.scanRate);
            System.out.println("ID: " + currentLibrary.id + "  , bookCount : " + bookScanOrder.size());
            myWriter.write(currentLibrary.id + " " + bookScanOrder.size());
            myWriter.write("\n");
            StringBuilder sbr = new StringBuilder();
            for (Long inpt : bookScanOrder){
                sbr.append(inpt).append(" ");
            }
            myWriter.write(sbr.toString());
            myWriter.write("\n");
            System.out.println(bookScanOrder);
        }
        myWriter.close();
    }

    private static List<Long> getBooks(long daysLeft, List<Long> bookList, long scanRate) {
        long requiredBooks = daysLeft * scanRate;
        List<Long> orderedBookList = new ArrayList<>();

        HashMap<Long, Long> bookScoreMap = new HashMap<>();
        for (Long bookIndex : bookList) {
            bookScoreMap.put(bookIndex, books.get(bookIndex));
        }

        List<Map.Entry<Long, Long>> bookScoreMapEntries = new ArrayList<>(bookScoreMap.entrySet());
        bookScoreMapEntries.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));

        for (int bookIndex = 0; bookIndex < requiredBooks && bookIndex < bookList.size(); bookIndex++) {
            orderedBookList.add(bookScoreMapEntries.get(bookIndex).getKey());
        }

        return orderedBookList;
    }

    private static long getLibraryScore(Library library, long maxOnboardingDay) {
        long score = 0;
        long requiredDays = maxOnboardingDay - library.onboardingTime;
        long booksPerDay = library.scanRate;
        long requiredBooks = booksPerDay * requiredDays;
        List<Long> scoreList = new ArrayList<>();

        for (Long scr : library.books) {
            scoreList.add(books.get(scr));
        }

        scoreList.sort(Collections.reverseOrder());

        int bookIndex = 0;
        for (long i = 0; i < requiredDays; i++) {
            for (; bookIndex < requiredBooks && bookIndex < scoreList.size(); bookIndex++) {
                score = score + scoreList.get(bookIndex);
            }
        }

        System.out.println("Library Id : "+library.id +" , score : " + score);
        return score;
    }
}

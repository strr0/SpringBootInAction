package com.example.demo.controller;

import com.example.demo.entity.Book;
import com.example.demo.entity.Reader;
import com.example.demo.repository.ReadingListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ReadingListController {
    private ReadingListRepository readingListRepository;

    @Autowired
    public ReadingListController(ReadingListRepository readingListRepository){
        this.readingListRepository = readingListRepository;
    }

    @GetMapping("/readingList")
    public String readersBooks(Reader reader, Model model){
        model.addAttribute(reader);
        List<Book> readingList = readingListRepository.findByReader(reader.getUsername());
        if(readingList != null){
            model.addAttribute("books", readingList);
        }
        return "readingList";
    }

    @PostMapping("/readingList")
    public String addToReadingList(Reader reader, Book book){
        book.setReader(reader.getUsername());
        readingListRepository.save(book);
        return "redirect:readingList";
    }
}

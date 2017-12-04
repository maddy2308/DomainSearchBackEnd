package com.zenefits.service;

import com.zenefits.model.Trie;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Service
public class DomainService {

    private Trie trie;

    public DomainService() {
        this.trie = new Trie();
        buildTrie();
    }

    private void buildTrie() {
        String csvFile = "src/main/resources/top-1m.csv";
        BufferedReader br = null;
        String line;
        final String cvsSplitBy = ",";
        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                // use comma as separator
                trie.insert(line.split(cvsSplitBy)[1]);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public Trie getTrie() {
        return trie;
    }
}

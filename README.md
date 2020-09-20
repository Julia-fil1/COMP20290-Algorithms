# algorithm-portfolio-20290-Julia-fil1
algorithm-portfolio-20290-Julia-fil1 created by GitHub Classroom

## About

This repository was created for [COMP20290 module - Algorithms](https://sisweb.ucd.ie/usis/!W_HU_MENU.P_PUBLISH?p_tag=MODULE&MODULE=COMP20290)

All of the programs were written in Java 13


## Contents

This repository includes the following Practicals


| Practical number                    | Topic covered              |
| ----------------------------------- | ---------------------------|
| Practical 1                         | Algorithm analysis         |
| Practical 2                         | Complexity                 |
| Practical 3                         | Recursion                  |
| Practical 4                         | Sorting                    |
| Practical 5                         | Sorting 2                  |
| Practical 6                         | Sorting 3                  |
| Practical 7                         | Substing search            |
| Practical 8                         | Trie                       |
| Practical 9                         | Data compression           |

## Data Compression Assignment
The task for this programming assignment was to implement a fully functional Huffman coding suite equipped with methods to both compress and decompress text files.
Huffman encoding is an example of a lossless compression algorithm that works particularly well on text but can, in fact, be applied to any type of file. Using Huffman encoding to compress a file can reduce the storage it requires by a third, half, or even more, in some situations. 
Huffman's algorithm is an example of a Greedy algorithm. It's called greedy because the two smallest nodes are chosen at each step, and this local decision results in a globally optimal encoding tree. In general, greedy algorithms use small-grained, or local minimal/maximal choices to result in a global minimum/maximum. 


## Some notes on my implementation of the Huffman compression algorithm

The file HuffmanCompression.java implements the Huffman compression algorithm
Please ensure that all the necessary files are compiled before execution.

- to count the number of bits in a particular file use the command

`java BinaryDump < filename.file_extension`

- to count the number of bits produced upon compression of a file

`java HuffmanCompression - < file.file_extension | java BinaryDump`

- to count the number of bits produced upon decompression of a file

`java HuffmanCompression + < file.file_extension | java BinaryDump`

- to output the compressed version of a file into a new file

`java HuffmanCompression - file.file_extension (the file to be compressed)  newFile.file_extension (the new file to be created with the compressed version of the file as its contents)`

- to output the decompressed version of a file into a new file

`java HuffmanCompression + file.file_extension (the file to be compressed)  newFile.file_extension (the new file to be created with the compressed version of the file as its contents)`

As well as implementing the Huffman algorithm within the HuffmanCompression.java file, I have also altered the RunLength.java file so as to be able to output the time it takes to execute the compression and decompression using that file. Please ensure that you use the updated version of that file while trying to time the RunLength compression.


### Acknowledgements
* [Dr. Mark Matthews](https://people.ucd.ie/mark.matthews)
* [UCD School of Computer Science](https://www.cs.ucd.ie/)

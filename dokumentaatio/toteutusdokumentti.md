

Io
* TextFileManager
* BinaryFileManager
* BitSequence, vaihtelevan pituinen sarja bittejä
* ByteBuffer, päivittää byte[] codedText -taulukkoa, tarvitaan koska bittejä kirjoitetaan sub-byte -resoluutiolla, ottaa vastaan ja palauttaa BitSequence-olioita
** private byte[] codedText
** private int numberOfEntries = 0
** private int freeBitsinLastByte = 8;

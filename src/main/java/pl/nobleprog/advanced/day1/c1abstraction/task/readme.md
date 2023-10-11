# Zadanie
Zdefiniuj klasę abstrakcyjną `Message` ze składowymi:
1) pole prywatne `content` typu łańcuchowego,
2) konstruktor parametryczny do inicjowania pola `content`, 
3) metoda abstrakcyjna `format` zwracająca łańcuch,
4) metoda zwracająca pole `content`. 

Zdefiniuj klasę `Email` dziedziczącą po `Message` z polami:
1) `from` z adresem wysyłającego
2) `to` z adresem docelowym
3) `subject` z tematem
4) zaimplementowaną metodą `format`, która zwraca łańcuch wg wzoru:
  
```text
    from: <pole `from`>
    to: <pole `to`>
    subject: <pole `subject`>
    content: <pole `content`>
```
np. 
```text
    from: adam@nobleprog.pl
    to: ewa@wp.pl
    subject: zajęcia
    content: Kiedy się zaczynają?
```
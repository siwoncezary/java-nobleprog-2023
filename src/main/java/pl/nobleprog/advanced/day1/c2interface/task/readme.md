# Zadanie
Zdefiniuj interfejs `History` z metodami:
- `insert` z parametrem typu `String`
- `last` z parametrem typu `int` zwracająca tablicę łańcuchów
Zdefiniuj własną implementację (np. `HistoryArray`) tego interfejsu, aby można było wykonać poniższy program:
```java
    History history = new HistoryArray();
    history.insert("abc");
    history.insert("123");
    history.insert("===");
    String[] last = history.last(2);
    for(var item: last){
        System.out.println(item);
    }
```
Efektem wykonania jest wyświetlenie `n` (w przykładzie dwóch) ostatnich wpisów historii w kolejności od najnowszego do najstarszego wpisu:
```text
===
123
```
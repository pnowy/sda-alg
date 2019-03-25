# Zadanie teoretyczne z złożoności obliczeniowej

Oppowiedzi na poniższe pytania używaj używając notacji `O(n)` (notacja dużego 'O')

1. Jaka jest złożoność obliczeniowa wyszukania konkretnego elementu w tablicy? (np konkretnego pacjenta po PESELu)
````
function GetByPesel(patients, pesel) {
    foreach(patient in patients){
        if(patient.Pesel == pesel) {
            return patient;
        }
    }
}
````

Odp. `O(n)`

Wyjaśnienie: musimy przejrzeć całą tablicę. Czasem znajdziemy poszukiwany element zanim dojdziemy do końca tablicy, można by uznać że złożoność w takim przypadku wynosi `O(n/2)`. Stałe występujące w notacji duże 'O' pomijamy jednak dlatego jeżeli program wymaga `n/2` operacji jego złożoność określona za pomocą notacji asymptotycznej (aka. notacja duże 'O') wynosi `O(n)`.


2. Jaka jest złożoność obliczeniowa wyszukania konkretnego elementu w tablicy haszowanej?

Odp. `O(1)`

Wyjaśnienie: Niezależnie od rozmiaru tablicy haszowanej wykonujemy taką samą ilość operacji by odczytać element. Gdy ilość operacji jest niezależna od ilości danych złożoność określamy jako stałą, czyli `O(1)`

3. Jaka jest złożoność obliczeniowa tego algorytmu sortowania:
```
procedure bubbleSort( A : list of sortable items )
    n = length(A)
    repeat
        swapped = false
        for i = 1 to n-1 inclusive do
            /* if this pair is out of order */
            if A[i-1] > A[i] then
                /* swap them and remember something changed */
                swap( A[i-1], A[i] )
                swapped = true
            end if
        end for
    until not swapped
end procedure
```

Odp. `O(n^2)`

Wyjaśnienie: Jest to algorytm sortowania bąbelkowego.

4. Jaka jest złożoność obliczeniowa poniższego algorytmu wypisującego wszystkie podzbiory danego zbioru (powerset)?
````
Input: Set[], set_size
1. Get the size of power set
    powet_set_size = pow(2, set_size)
2  Loop for counter from 0 to pow_set_size
     (a) Loop for i = 0 to set_size
          (i) If ith bit in counter is set
               Print ith element from set for this subset
     (b) Print seperator for subsets i.e., newline
````

````
Example:
Set  = [a,b,c]
power_set_size = pow(2, 3) = 8
Run for binary counter = 000 to 111

Value of Counter            Subset
    000                    -> Empty set
    001                    -> a
    010                    -> b
    011                    -> ab
    100                    -> c
    101                    -> ac
    110                    -> bc
    111                    -> abc
````

Odp. `O(2^n)`

Wyjaśnienie: Główna pętla algorytmu wykonuje się dla `i` od `0` do `set_size`. Wartość `set_size` to `2^n`

5. Jaka jest złożoność obliczeniowa sprawdzenia czy dana liczba znajduje się w Binarnym Drzewie Poszukiwań (BST)?

Odp. `O(logn)` (W przpadku zbalansowanego drzewa binarnego)

6. Jaka jest złożoność obliczeniowa sprawdzenia czy liczba jest parzysta?
````
function isEven(n)
    return n % 2 == 0;
````

Odp. `O(1)`

7. Jaka jest złożoność obliczeniowa znalezienia największego elementu w tablicy?

Odp. `O(n)`

8. Jaka jest złożoność obliczeniowa znalezienia największego elementu w kopcu?

Odp. `O(1)`

9. Jaka jest złożoność obliczeniowa tej funkcji:
````
function sample_data(data_array)
for i = 1 to 100
    for j = 1 to 200
        write-output data_array[i][j]
````

Odp. `O(1)`

Wyjaśnienie: ilość operacji które wykonuje funkcja nie zależy od rozmiaru wejścia.

10. Jaka jest złożoność obliczeniowa tej funkcji:
````
function sample_data(data_array)
for i = 1 to min(100, data_array.length1d)
    for j = 1 to min(200, data_array.length2d)
        write-output data_array[i][j]
````

Odp. `O(1)`

Wyjaśnienie: ilość operacji które wykonuje funkcja nie zależy od rozmiaru wejścia jeżeli tablica wejściowa jest większa niż 100x200. W przypadku określania złożoności obliczeniowej interesuje nas tempo wzrotu ilość operacji wykonywanych przy dla bardzo dużych i rosnących `n`

11. Jaka jest złożoność obliczeniowa sprawdzenia czy dana liczba występuje w posortowanej tablicy?

Odp. zależnie od zastosowanego algorytmu. W przypadku naiwnego poszukiwania liniowego będzie to `O(n)`. W przypadku poszukiwania metodą bisekcji (korzystając z tego że tablica jest posortowana) będzie to `O(logn)`
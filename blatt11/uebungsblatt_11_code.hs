-- Aufgabe 2
import Text.Show.Functions
import Data.List

-- a)
data BinTree a b = Leaf b | Node a (BinTree a b) (BinTree a b) deriving Show

-- b)

example :: BinTree (Int -> Bool) Char
example = Node (\x -> x > 4)
        (Node (\x -> x * x == x)
            (Leaf 'g') (Node (\x -> x == 0)
                (Leaf 'u')(Leaf 'l')))
                    (Node (\x -> x >= 7) (Leaf 'f') (Leaf 'i'))
                      
--c)
countInnerNodes :: BinTree a b -> Int
countInnerNodes (Leaf b) = 0
countInnerNodes (Node _ t1 t2) = 1 + countInnerNodes t1 + countInnerNodes t2

--d)
decodeInt :: (BinTree (Int -> Bool) b) -> Int -> b
decodeInt (Leaf val) _ = val
decodeInt (Node a b1 b2) x
    | a x == False = decodeInt b1 x
    | otherwise = decodeInt b2 x

--e)
decode :: (BinTree (Int -> Bool) b) -> [Int] -> [b]
decode bt xs = map (decodeInt bt) xs

--f)
mapTree :: (b -> c) -> BinTree a b -> BinTree a c
mapTree f (Leaf val) = Leaf (f val)
mapTree f (Node a left right) = Node a (mapTree f left) (mapTree f right)

 
-- Aufgabe 6
data List a = Nil | Cons a (List a) deriving Show

list :: List Int
list = Cons (-3) (Cons 14 (Cons (-6) (Cons 7 (Cons 1 Nil))))

blist :: List Int
blist = Cons 1 (Cons 1 (Cons 0 (Cons 0 Nil)))

--a)
filterList :: (a -> Bool) -> List a -> List a
filterList _ Nil = Nil
filterList f (Cons val alist) = if (f val)
      then Cons val (filterList f alist)
           else filterList f alist

--b)
divisibleBy :: Int -> List Int -> List Int
divisibleBy d xs = filterList (\x -> rem x d == 0) xs

--c)
foldList :: (a -> b -> b) -> b -> List a -> b
foldList f c (Cons val Nil) = f val c
foldList f c (Cons val xs) = f val (foldList f c xs)

plus :: Int -> Int -> Int
plus x y = x + y

--d)
listMaximum :: List Int -> Int
listMaximum (Cons val xs) = if foldList f minBound xs
       then val
          else listMaximum xs
               where
                  f :: Int -> Bool -> Bool
                  f x _ = x < val

--e)
mapList :: (a -> b) -> List a -> List b
mapList f xs = foldList (\x r -> Cons (f x) r) Nil xs

--f)
zipLists :: (a -> b -> c) -> List a -> List b -> List c
zipLists f Nil _ = Nil
zipLists f _ Nil = Nil
zipLists f (Cons x xs) (Cons y ys) = Cons (f x y) (zipLists f xs ys)

--g)
skalarprodukt :: List Int -> List Int -> Int
skalarprodukt xs ys = foldList plus 0 (zipLists (\x y -> x * y) xs ys)

-- Aufgabe 8)
strings :: Int -> [ String ]
strings 0 = [""]
strings n = concat (map (\x -> map (\tail -> x : tail) tails) ['a'..'z'])
      where tails = strings (n-1)

palindrom :: Int -> [String]
palindrom 0 = []
palindrom n = zip (strings n) (strings n) ++ palindrom (n+1)
      where 
          zip :: [String] -> [String] -> [String]
          zip [] ys = []
          zip xs [] = []
          zip (x:xs) (y:ys) = (x ++ (reverse y)) : zip xs ys

--b)
divisors :: Int -> [Int]
divisors x = filter (\y -> rem x y == 0) [1..div x 2]

perfectList :: Int -> [Int]
perfectList x = if (sum (divisors x) == x) then x : perfectList (x+1) else perfectList (x+1)

--c)
semiperfectList :: Int -> [Int]
semiperfectList x = if any (\a -> a == x) (summe subs) then x : semiperfectList (x+1) else semiperfectList (x+1)
    where
        summe :: [[Int]] -> [Int]
        summe [] = []
        summe (x:xs) = sum x : summe xs
         
        subs = subsequences (divisors x)

--d)
fibInit :: Int -> Int -> [Int]
fibInit a b = a : (fibInit b (a+b))

fib :: [Int]
fib = fibInit 0 1
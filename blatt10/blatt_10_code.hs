fibInit :: Int -> Int -> Int -> Int
fibInit a0 a1 0 = a0
fibInit a0 a1 1 = a1
fibInit a0 a1 n = fibInit a0 a1 (n-1) + fibInit a0 a1 (n-2)

fibInitL :: Int -> Int -> Int -> [Int]
fibInitL a0 a1 n = take (n+1) (fibo a0 a1)

fibo :: Int -> Int -> [Int]
fibo a b = a:fibo b (a+b)

-- fibNext :: [Int] -> [Int]
-- fibNext (xs : a : b) = xs ++ a : b : [[a+b]]

fibInit2 :: Int -> Int -> Int -> Int
fibInit2 a0 a1 n = take' n (fibInitL a0 a1 n)
  where
    take' :: Int -> [Int] -> Int
    take' n [] = error "Overflow."
    take' 0 (x:_) = x
    take' n (x:xs) = take' (n-1) xs

-- 6c)

normalize :: [Int] -> [Int]
normalize x = addToAll x (minim x)

addToAll :: [Int] -> Int -> [Int]
addToAll [] _ = []
addToAll [x] a = [x+a]
addToAll (x:xs) a | a >= 0 = (x + a): addToAll xs a
                  | a < 0 = (x - a): addToAll xs (-a)

minim :: [Int] -> Int
minim [] = 0
minim [x] = x
minim (x:xs) = min x (minim xs)

mini :: Int -> Int -> Int
mini a b | a < b = a
         | a > b = b
         | a == b = a

-- d)

sumMax :: [Int] -> Int
sumMax [] = 0
sumMax xs = addTo (reverseList xs)

addTo :: [Int] -> Int
addTo [] = 0
addTo [x] = x
addTo (x:xs) | x > (maxm xs) = x + addTo xs
             | otherwise = 0 + addTo xs

reverseList :: [Int] -> [Int]
reverseList [] = []
reverseList (x:xs) = reverseList xs ++ [x]

maxm :: [Int] -> Int
maxm [] = 0
maxm [x] = x
maxm (x:xs) = maxi x (maxm xs)

maxi :: Int -> Int -> Int
maxi a b | a < b = b
         | a > b = a
         | a == b = a

-- e)
sumNonMins :: [Int] -> Int
sumNonMins [] = 0
sumNonMins xs = sumNonMinsHelper (reverseList xs)


sumNonMinsHelper :: [Int] -> Int
sumNonMinsHelper [] = 0
sumNonMinsHelper (x:xs) | isBiggerThanOne xs x == True = x + sumNonMinsHelper xs
                        | isBiggerThanOne xs x == False = sumNonMinsHelper xs

isBiggerThanOne :: [Int] -> Int -> Bool
isBiggerThanOne [] _ = False
isBiggerThanOne (x:xs) a | a > x = True
                         | a <= x = isBiggerThanOne xs a

-- f)

primeTwins :: Int -> (Int, Int)
primeTwins x | (prime (x+1)) && (prime (x+3)) = (x+1,x+3)
             | otherwise = primeTwins (x+1)

-- code aus der Tutoriumsaufgabe
prime :: Int -> Bool
prime 0 = False
prime 1 = False
prime 2 = True
prime n = primeTest n (n-1)

primeTest :: Int -> Int -> Bool
primeTest n m | m == 1 = True
              | (rem n m == 0) = False
              | otherwise = primeTest n (m-1)

-- g)
multiples :: [Int] -> Int -> Int -> [Int]
multiples xs i0 i1
  | i0 > i1 = []
  | otherwise = calcMults (range' i0 i1) xs
  where
    checkMultiples :: Int -> [Int] -> Bool
    checkMultiples _ [] = False
    checkMultiples a (x:xs)
      | rem a x == 0 = True
      | otherwise = checkMultiples a xs
      
    range' a b
      | a <= b = a : range' (a+1) b
      | otherwise = []
    
    calcMults [] _ = []
    calcMults (x:xs) ys
      | checkMultiples x ys = x : calcMults xs ys
      | otherwise = calcMults xs ys

s = open("decisions_ege_2024/dataFile/24-280__3ba6k.txt").readline()

letters = 'XY'
targetCount = 1

count = { let: 0 for let in letters }
i = 0
maxLen = 0
for j, c in enumerate(s):
  for let in letters:
    count[let] += c == let
  while any( count[let] > targetCount for let in letters ):
    for let in letters:
      count[let] -= s[i] == let
    i += 1
  if all( count[let] == targetCount for let in letters ):
    maxLen = max( j - i + 1, maxLen )

print( maxLen )

def quicksort(list):
  return _quicksort(list, 0, len(list)-1)

def _quicksort(list, start, end): 
  if start >= end:
    return list
  pivot = list[end]
  x = start
  y = end - 1
  while y > x:
    if list[x] < pivot:
      x = x + 1
    elif list[y] > pivot:
      y = y - 1
    else:
      tmp = list[x]
      list[x] = list[y]
      list[y] = tmp
  if list[x] > pivot:
    tmp = list[x]
    list[x] = pivot
    list[end] = tmp
  _quicksort(list, start, list.index(pivot) - 1)
  _quicksort(list, list.index(pivot), end)
  return list


import random
import time


def selection_sort(arr):
    n = len(arr)

    for i in range(n - 1):
        min_index = i

        # Find the index of the minimum element in the unsorted part of the array
        for j in range(i + 1, n):
            # If the current is smaller than the min, change the min
            if arr[j] < arr[min_index]:
                min_index = j

        # Swap the minimum element with the first element of the unsorted part
        arr[i], arr[min_index] = arr[min_index], arr[i]

def generate_unique_array(size, min_val, max_val):
    array = []
    unique_set = set()

    while len(array) < size:
        random_number = random.randint(min_val, max_val)
        if random_number not in unique_set:
            array.append(random_number)
            unique_set.add(random_number)

    return array

def main():
    array_size = 1000
    num_arrays = 1000
    min_val = 1
    max_val = 1000
    num_trials = 100

    times = []

    for j in range(num_trials):
        arrays = []

        # Generate unique arrays
        for i in range(num_arrays):
            array = generate_unique_array(array_size, min_val, max_val)
            arrays.append(array)

        # Sort arrays
        start_time = time.time()
        for array in arrays:
            selection_sort(array)
        end_time = time.time()

        duration = (end_time - start_time) * 1000  # Convert to milliseconds
        times.append(duration)

    total = sum(times)
    average = total / num_trials
    print("Average time in ms: ", average)


if __name__ == "__main__":
    main()
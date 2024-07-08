package com.sorting.servlet;

import java.io.IOException;
import java.util.Arrays;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/")
public class SortsController extends HttpServlet {

    private BucketSort bucketSort = new BucketSort();
    private HeapSort heapSort = new HeapSort();
    private InsertionSort insertionSort = new InsertionSort();
    private MergeSort mergeSort = new MergeSort();
    private QuickSort quickSort = new QuickSort();
    private RadixSort radixSort = new RadixSort();
    private ShellSort shellSort = new ShellSort();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // Get input array from request
            String[] inputArrayStr = request.getParameter("inputArray").split(",");
            int[] inputArray = Arrays.stream(inputArrayStr).mapToInt(Integer::parseInt).toArray();

            // Get the sorting algorithm parameter
            String sortType = request.getParameter("sortType");

            // Perform sorting based on the selected algorithm
            int[] sortedArray;
            switch (sortType) {
                case "Bucket Sort":
                    sortedArray = bucketSort.sort(inputArray);
                    break;
                case "Heap Sort":
                    sortedArray = heapSort.sort(inputArray);
                    break;
                case "Insertion Sort":
                    sortedArray = insertionSort.sort(inputArray);
                    break;
                case "Merge Sort":
                    sortedArray = mergeSort.sort(inputArray);
                    break;
                case "Quick Sort":
                    sortedArray = quickSort.sort(inputArray);
                    break;
                case "Radix Sort":
                    sortedArray = radixSort.sort(inputArray);
                    break;
                case "Shell Sort":
                    sortedArray = shellSort.sort(inputArray);
                    break;
                default:
                    throw new IllegalArgumentException("Unsupported sort type: " + sortType);
            }

            // Set attributes for input array and sorted array
            request.setAttribute("sortType", sortType);
            request.setAttribute("inputArray", Arrays.toString(inputArray));
            request.setAttribute("sortedArray", Arrays.toString(sortedArray));

            // Forward the request to the JSP page
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } catch (NumberFormatException e) {
            // Handle number format exception if the input array contains non-integer values
            request.setAttribute("error", "Invalid input. Please enter a valid array of integers separated by commas.");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } catch (Exception e) {
            // Handle other unexpected exceptions
            request.setAttribute("error", "An error occurred: " + e.getMessage());
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
}

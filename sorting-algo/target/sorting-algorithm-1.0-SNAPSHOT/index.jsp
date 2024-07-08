<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Sort Result</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #eaeff3;
            color: #2c3e50;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .container {
            width: 100%;
            max-width: 600px;
            padding: 20px;
            background-color: #ffffff;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            text-align: center;
        }
        h1 {
            color: #3498db;
            margin-bottom: 20px;
        }
        form {
            display: flex;
            flex-direction: column;
            align-items: center;
        }
        label {
            width: 100%;
            margin-bottom: 10px;
            color: #7f8c8d;
            text-align: left;
        }
        input[type="text"], select {
            width: 100%;
            padding: 12px;
            margin-bottom: 20px;
            border: 1px solid #bdc3c7;
            border-radius: 5px;
            font-size: 16px;
        }
        button {
            padding: 12px 20px;
            background-color: #3498db;
            border: none;
            border-radius: 5px;
            color: #ffffff;
            font-size: 16px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }
        button:hover {
            background-color: #2980b9;
        }
        .results {
            margin-top: 30px;
            padding: 20px;
            background-color: #ecf0f1;
            border-radius: 10px;
            text-align: left;
        }
        .results p {
            margin: 10px 0;
            font-size: 18px;
        }
        .results p strong {
            color: #3498db;
        }
        .error {
            color: #e74c3c;
            margin-top: 10px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Enter an Array to Sort</h1>
        <form action="${pageContext.request.contextPath}/sort" method="post">
            <label for="inputArray">Array (comma-separated values):</label>
            <input type="text" id="inputArray" name="inputArray" required>
            <label for="sortType">Choose a sort type:</label>
            <select id="sortType" name="sortType" required>
                <option value="Insertion Sort">Insertion Sort</option>
                <option value="Shell Sort">Shell Sort</option>
                <option value="Merge Sort">Merge Sort</option>
                <option value="Quick Sort">Quick Sort</option>
                <option value="Heap Sort">Heap Sort</option>
                <option value="Radix Sort">Radix Sort</option>
                <option value="Bucket Sort">Bucket Sort</option>
            </select>
            <button type="submit">Sort</button>
        </form>
        <c:if test="${not empty error}">
            <p class="error">${error}</p>
        </c:if>
        <h1>Sort Result</h1>
        <c:if test="${not empty sortedArray}">
            <div class="results">
                <p><strong>Sort Type:</strong> ${sortType}</p>
                <p><strong>Input Array:</strong> ${inputArray}</p>
                <p><strong>Sorted Array:</strong> ${sortedArray}</p>
            </div>
        </c:if>
    </div>
</body>
</html>

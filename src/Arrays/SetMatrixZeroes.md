# Optimized Approach for Setting Matrix Zeroes

## 🧠 Problem Statement

Given an `m x n` matrix, if an element is `0`, set its entire row and column to `0`.  
Do it **in-place** with **O(1)** space complexity (excluding the input matrix itself).

---

## ✅ Intuition

Instead of using additional arrays to keep track of rows and columns to be zeroed, we **reuse the first row and first column of the matrix** as markers:

- If an element `matrix[i][j]` is `0`, mark the first element of row `i` (`matrix[i][0]`) and the first element of column `j` (`matrix[0][j]`) as `0`.
- These markers help in the second pass to zero the appropriate rows and columns.

---

## ⚠️ Special Handling for First Row and Column

Since `matrix[0][0]` lies at the intersection of the first row and column, we cannot use it to track both.  
So, we use a separate variable:

- `colZero` — a flag to indicate if the **first column** should be set to zero.

Why not `rowZero`?

- Because `matrix[0][0]` still safely serves as the **first row marker** (we treat it accordingly in the final step).

---

## ✅ Algorithm Steps

### 🔹 Step 1: Mark Rows and Columns

- Loop through the matrix.
- If an element is `0`:
    - Set `matrix[i][0] = 0`
    - Set `matrix[0][j] = 0`
    - If it’s in the **first column**, also set `colZero = 0`

### 🔹 Step 2: Set matrix cells based on markers

- For cells `(i, j)` from `(1,1)`:
    - If either `matrix[i][0] == 0` or `matrix[0][j] == 0`, set `matrix[i][j] = 0`

### 🔹 Step 3: Handle the first row and column separately

- If `matrix[0][0] == 0`, set the **first column** to zero
- If `colZero == 0`, set the **first row** to zero

---

## 📌 Example Walkthrough (from handwritten notes)

### 🔹 Initial Input Matrix

|     | 0 | 1 | 2 |
|-----|---|---|---|
| **0** | 1 | 0 | 1 |
| **1** | 1 | 1 | 1 |
| **2** | 1 | 0 | 1 |

---

### 🔹 After Step 1 (Marking Phase)

- `matrix[0][1] = 0` (because of 0 at [0][1])
- `matrix[2][0] = 0`, `matrix[0][1] = 0` (because of 0 at [2][1])

Marked matrix:

|     | 0 | 1 | 2 |
|-----|---|---|---|
| **0** | 1 | 0 | 1 |
| **1** | 1 | 1 | 1 |
| **2** | 0 | 0 | 1 |

---

### 🔹 After Step 2 (Zeroing based on markers)

|     | 0 | 1 | 2 |
|-----|---|---|---|
| **0** | 1 | 0 | 1 |
| **1** | 1 | 0 | 1 |
| **2** | 0 | 0 | 0 |

---

### 🔹 After Step 3 (Final Matrix)

|     | 0 | 1 | 2 |
|-----|---|---|---|
| **0** | 0 | 0 | 0 |
| **1** | 1 | 0 | 1 |
| **2** | 0 | 0 | 0 |

---


# SI_2025_lab2_236093

---

## Дамјан Зимбаков — 236093

---

## Control Flow Graph

![Control Flow Diagram](SI_lab2_236093/docs/images/diagram.png)

![Code Graph](SI_lab2_236093/docs/images/code.png)

---

## Цикломатска комплексност

Цикломатската комплексност на овој код изнесува **9**, пресметано преку бројот на региони.

---

## Unit тестови

| Тест  | `allItems`                            | `cardNumber`            | Очекуван резултат                                         |
|:-----:|:--------------------------------------|:------------------------|:----------------------------------------------------------|
| 1     | `null`                                | `""`                   | `RuntimeException("allItems list can't be null!")`      |
| 2     | `[{ 'Laptop', 1, 1, 0 }]`             | `""`                   | `RuntimeException("Invalid card number!")`              |
| 3     | `[{ 'Laptop', 1, 1, 0 }]`             | `"123451234512345a"`   | `RuntimeException("Invalid character in card number!")` |
| 4     | `[{ null, 0, 0, 0 }]`                 | `""`                   | `RuntimeException("Invalid item!")`                     |
| 5     | `[{ 'Laptop', 1, 1, 0 }]`             | `"1234512345123456"`   | `1`                                                       |

**Дополнителни пресметки:**

```text
1. allItems = [{ 'Laptop', 0, 250, 0 }]  → -30
2. allItems = [{ 'Laptop', 0, 1, 0.1 }]  → -30
3. allItems = [{ 'Laptop', 2, 3, 0 }]    → 6
4. allItems = [{ 'Laptop', 15, 10, 0.1 }]→ 105

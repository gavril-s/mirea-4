def main(m: int, a: int, b: int, y: float) -> float:
    result = 0
    for k in range(1, b + 1):
        for j in range(1, a + 1):
            for i in range(1, m + 1):
                result += (99 + j / 45 + i**2) ** 3 - y**7 / 32 - 4 * k
    return result

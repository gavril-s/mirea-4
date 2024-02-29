import math


def main(n: int) -> float:
    if n == 0:
        return -0.15
    return main(n - 1) - 0.03 - math.atan(main(n - 1)) ** 2

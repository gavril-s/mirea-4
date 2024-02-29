from math import tan


def main(z, x):
    return (
        (38 * abs(53 * z**3 + x) ** 5 - (z + 36 * z**2 + 31) ** 7)
        / (13 * tan(3 - 84 * x**3 - 33 * z) ** 5)
        + 69 * z**6
        - 82 * (x**3 / 8) ** 4
    )

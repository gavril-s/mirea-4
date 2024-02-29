import math


def main(y: float) -> float:
    if y < 188:
        return 13 * math.tan(84 - 33 * y**2) ** 2
    elif y < 199:
        return 3 * math.atan(y) ** 5 - math.cos(y) ** 6
    elif y < 228:
        return math.sin(y**3 + y**2) ** 3
    elif y < 301:
        return 52 * (y + 1 + y**3) ** 3
    else:
        return 37 * y**7

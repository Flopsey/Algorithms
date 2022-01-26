def gcd(a: int, b: int) -> int:
    while b != 0:
        a, b = b, a % b
    return a


def lcm(a: int, b: int) -> int:
    return (a * b) // gcd(a, b)

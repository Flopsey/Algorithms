from numbers import Integral


def gcd(a: Integral, b: Integral) -> Integral:
    while b != 0:
        a, b = b, a % b
    return a


def lcm(a: Integral, b: Integral) -> Integral:
    return (a * b) // gcd(a, b)

def extended_gcd(a: int, b: int) -> tuple[int, tuple[int, int]]:
    u1, u2, v1, v2 = 1, 0, 0, 1
    while b != 0:
        a, (q, b) = b, divmod(a, b)
        u1, u2, v1, v2 = (u2,
                          u1 - q * u2,
                          v2,
                          v1 - q * v2)
    return a, (u1, v1)

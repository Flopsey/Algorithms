import secrets


class Agent:
    p: int  # Public prime
    g: int  # Public generator
    x: int  # Secret key
    y: int  # Public key
    k: int  # Shared key

    def __init__(self, p: int, g: int):
        self.p = p
        self.g = g
        self.x = secrets.randbelow(p - 1)
        self.y = pow(g, self.x, p)

    def key(self) -> int:
        return self.y

    def receive_key(self, y_other: int):
        self.k = pow(y_other, self.x, self.p)


def protocol(p: int, g: int):
    alice = Agent(p, g)
    bob = Agent(p, g)
    y_a, y_b = alice.key(), bob.key()  # Insecure channel
    alice.receive_key(y_b), bob.receive_key(y_a)
    assert alice.k == bob.k  # Alice and Bob have the same shared key

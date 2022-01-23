import secrets
from numbers import Integral


class Agent:
    p: Integral  # Public prime
    g: Integral  # Public generator
    x: Integral  # Secret key
    y: Integral  # Public key
    k: Integral  # Shared key

    def __init__(self, p: Integral, g: Integral):
        self.p = p
        self.g = g
        self.x = secrets.randbelow(p - 1)
        self.y = pow(g, self.x, p)

    def key(self) -> Integral:
        return self.y

    def receive_key(self, y_other: Integral):
        self.k = pow(y_other, self.x, self.p)


def protocol(p: Integral, g: Integral):
    alice = Agent(p, g)
    bob = Agent(p, g)
    y_a, y_b = alice.key(), bob.key()  # Insecure channel
    alice.receive_key(y_b), bob.receive_key(y_a)
    assert alice.k == bob.k  # Alice and Bob have the same shared key

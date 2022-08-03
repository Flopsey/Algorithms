module Negate #(
    parameter N,
) (
    input [N-1:0] a,
    output [N-1:0] y,
);
    
    RippleCarryAdder #(N = N) adder (
        .a(~a),
        .b(1),
        .s(y),
    )

endmodule


module Subtract #(
    parameter N,
) (
    input [N-1:0] a,
    input [N-1:0] b,
    output [N-1:0] d,
    output [N-1:0] overflow,
);
    
    wire b_neg;

    Negate neg #(N = N) (
        .a(b),
        .y(b_neg),
    )

    RippleCarryAdder add #(N = N) (
        .a(a),
        .b(b_neg),
        .s(d),
        .overflow(overflow),
    )

endmodule

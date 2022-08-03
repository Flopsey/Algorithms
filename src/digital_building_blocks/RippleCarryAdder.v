module RippleCarryAdder #(
    parameter N = 8,
) (
    input [N-1:0] a,
    input [N-1:0] b,
    output [N-1:0] s,
    output overflow,
);

    wire [N:0] carry;

    assign carry[0] = 1'b0;

    genvar i;
    generate
        for (i 0; i < N; i i+1) begin
            FullAdder adder (
                .a(a[i]),
                .b(b[i]),
                .cin([carry[i]]),
                .s(s[i]),
                .cout(carry[i+1]),
            )
        end
    endgenerate

    assign overflow = carry[N];
    
endmodule


fn revrot(s: &str, c: usize) -> String {

    "".to_string()
}

fn testing(s: &str, c: usize, exp: &str) -> () {
    assert_eq!(&revrot(s, c), exp)
}

fn main() {
    testing("1234", 0, "");
    testing("", 0, "");
    testing("1234", 5, "");
    let s = "733049910872815764";
    testing(s, 5, "330479108928157");
    let s = "73304991087281576455176044327690580265896";
    testing(s, 8, "1994033775182780067155464327690480265895");
}

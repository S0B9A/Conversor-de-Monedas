public record Conversion(String base_code, String target_code, double conversion_rate, double conversion_result) {

    @Override
    public String toString() {
        return "\nMoneda base: " + base_code +
                "\nMoneda Destino: " + target_code +
                "\nconversion rate: " + conversion_rate +
                "\nconversion result: " + conversion_result;
    }
}

public class Helpers {
    public static boolean isInArray(String item, String[] array) {
        for (String element : array) {
            if (element.equals(item)) {
                return true;
            }
        }
        return false;
    }

    public static void formattedPrint(Record [] records) {
        System.out.format("%-15s %-15s %-15s %-15s %-20s %-15s\n",
                "RecordID", "CustomerID", "LoanType", "IntRate", "AmountLeft", "TimeLeft");
        for (Record record : records) {
            System.out.format("%-15s %-15s %-15s %-15s %-20s %-15s\n",
                    record.getRecordId(), record.getCustomerId(), record.getLoanType(),
                    record.getInterestRate(), record.getAmountLeftToPay(), record.getLoanTermLeft());
        }

        System.out.println("_________________________________");
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
    }
}

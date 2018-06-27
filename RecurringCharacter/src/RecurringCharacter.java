public class RecurringCharacter {
    public static void main(String[] args) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        Character[] characters = { 'A', 'B', 'C', 'E', 'B'};
        Character recurringCharacter = null;
        for (Character character: characters) {
            if(hashMap.get(character) == null)
            {
                hashMap.put(character, 1);
            }
            else
            {
                recurringCharacter = character;
            }
        }
        if(recurringCharacter != null)
        {
            System.out.println("Recurring Character is " + recurringCharacter);
        }
        else
        {
            System.out.println("No Recurring Characters");
        }
    }
}

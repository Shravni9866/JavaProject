import java.util.ArrayList;
import java.util.Scanner;

class Task {
    private String description;
    private boolean isCompleted;

    public Task(String description) {
        this.description = description;
        this.isCompleted = false;
    }

    public void markAsCompleted() {
        isCompleted = true;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return (isCompleted ? "[✔] " : "[ ] ") + description;
    }
}

public class ToDoListApp {

    public static void printBanner() {
        System.out.println("===========================================");
        System.out.println("     ✨ WELCOME TO YOUR TO-DO LIST ✨      ");
        System.out.println("===========================================");
    }

    public static void printMenu() {
        System.out.println("\n🗂️  MENU OPTIONS");
        System.out.println("1️⃣  Add New Task");
        System.out.println("2️⃣  View All Tasks");
        System.out.println("3️⃣  Mark Task as Completed");
        System.out.println("4️⃣  Delete a Task");
        System.out.println("5️⃣  Exit");
        System.out.print("👉 Choose an option (1-5): ");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Task> tasks = new ArrayList<>();

        printBanner();

        int choice;
        do {
            printMenu();
            while (!scanner.hasNextInt()) {
                System.out.print("❌ Invalid input. Please enter a number (1-5): ");
                scanner.next(); // clear the invalid input
            }

            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> {
                    System.out.print("📝 What's the task? ");
                    String desc = scanner.nextLine().trim();
                    if (!desc.isEmpty()) {
                        tasks.add(new Task(desc));
                        System.out.println("✅ Task added successfully!");
                    } else {
                        System.out.println("⚠️  Task cannot be empty.");
                    }
                }

                case 2 -> {
                    if (tasks.isEmpty()) {
                        System.out.println("📭 You have no tasks yet. Time to get productive!");
                    } else {
                        System.out.println("\n📋 YOUR TASKS:");
                        for (int i = 0; i < tasks.size(); i++) {
                            System.out.println((i + 1) + ". " + tasks.get(i));
                        }
                    }
                }

                case 3 -> {
                    if (tasks.isEmpty()) {
                        System.out.println("❌ No tasks to mark. Add one first!");
                        break;
                    }
                    System.out.print("✅ Enter task number to mark as completed: ");
                    int index = scanner.nextInt() - 1;
                    if (index >= 0 && index < tasks.size()) {
                        tasks.get(index).markAsCompleted();
                        System.out.println("🎉 Task marked as completed!");
                    } else {
                        System.out.println("❌ Invalid task number.");
                    }
                }

                case 4 -> {
                    if (tasks.isEmpty()) {
                        System.out.println("❌ No tasks to delete.");
                        break;
                    }
                    System.out.print("🗑️ Enter task number to delete: ");
                    int index = scanner.nextInt() - 1;
                    if (index >= 0 && index < tasks.size()) {
                        Task removed = tasks.remove(index);
                        System.out.println("🗑️ Deleted: \"" + removed.getDescription() + "\"");
                    } else {
                        System.out.println("❌ Invalid task number.");
                    }
                }

                case 5 -> {
                    System.out.println("\n🌈 Thanks for using your personal To-Do List App!");
                    System.out.println("Stay focused, stay organized. 💪");
                }

                default -> System.out.println("🚫 Invalid choice. Try picking 1-5.");
            }

        } while (choice != 5);

        scanner.close();
    }
}

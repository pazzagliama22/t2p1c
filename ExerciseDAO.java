
/**
 *
 * @author Your TEAM2
 */
public class ExerciseDAO {

    private final String fileName;
    protected final List<Exercise> myList;

    public ExerciseDAO() {
        this("empdata.txt");
    }

    public ExerciseDAO(String fileName) {
        this.fileName = fileName;
        this.myList = new ArrayList<>();
        try {
            Files.createFile(Paths.get(fileName));
        } catch (FileAlreadyExistsException fae) {
            ;
        } catch (IOException ioe) {
            System.out.println("Create file error with " + ioe.getMessage());
        }
        readList();
    }

    public void createRecord(Exercise member) {
        myList.add(member);
        writeList();
    }

    public Exercise retrieveRecord(int id) {
        for (Exercise member : myList) {
            if (member.getId() == id) {
                return member;
            }
        }
        return null;
    }

    public void updateRecord(Exercise updatedExercise) {
        for (Exercise member : myList) {
            if (member.getId() == updatedExercise.getId()) {
                member.setMemberNumber(updatedExercise.getMemberNumber());
                member.setexcerciseType(updatedExercise.getexcerciseType());
                member.setDate(updatedExercise.getDate());
                member.setTime(updatedExercise.getTime());
                break;
            }
        }
        writeList();
    }

    public void deleteRecord(int id) {
        for (Exercise member : myList) {
            if (member.getId() == id) {
                myList.remove(member);
                break;
            }
        }
        writeList();
    }

    public void deleteRecord(Exercise member) {
        myList.remove(member);
        writeList();
    }

    protected void readList() {
        Path path = Paths.get(fileName);
        try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                String Member = data[1];
                String Exercise = data[2];
                String Date = data[3];
                double Time = Double.parseDouble(data[4]);
                String Comments = data[5];
                Exercise member = new Exercise(id, Member, Exercise, Date, Time, Comments);
                myList.add(member);
            }
        } catch (IOException ioe) {
            System.out.println("Read file error with " + ioe.getMessage());
        }
    }
//retrieve
    protected void writeList() {
        Path path = Paths.get(fileName);
        try (BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {
            for (Exercise member : myList) {
                writer.write(String.format("%d,%s,%s,%s,%.2f\n",
                        member.getId(),
                        member.getMemberNumber(),
                        member.getexcerciseType(),
                        member.getDate(),
                        member.getTime(),
                        member.getComments();
            }
        } catch (IOException ioe) {
            System.out.println("Write file error with " + ioe.getMessage());
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        myList.stream().forEach((member) -> {
            sb.append(String.format("%5d : %s, %s, %s, %.2f\n", member.getId(),
                    member.getMemberNumber(), member.getexcerciseType(),
                    member.getDate(), member.getTime()));
        });

        return sb.toString();
    }
}

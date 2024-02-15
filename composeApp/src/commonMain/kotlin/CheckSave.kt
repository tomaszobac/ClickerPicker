import java.nio.file.Files
import java.nio.file.Paths

fun ensureDirectoryAndFileExist(basePath: String, dirName: String, fileName: String) {
    val directoryPath = Paths.get(basePath, dirName)

    if (Files.notExists(directoryPath)) {
        Files.createDirectories(directoryPath)
    }

    val filePath = directoryPath.resolve(fileName)

    if (Files.notExists(filePath)) {
        Files.createFile(filePath)
        filePath.toFile().writeText("{\"highScore\": 0}")
    }
}
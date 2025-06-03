package com.yandexbrouser.kotlinshell.commands

import com.yandexbrouser.kotlinshell.filesystem.VirtualFileSystem

class CatCommand(private val fileSystem: VirtualFileSystem) : Command {
  override fun execute(args: List<String>): String {
    if (args.isEmpty()) {
      return "No file specified."
    }

    val fileName = args[0]
    val content = fileSystem.readFileContent(fileName)
    return content ?: "File not found: $fileName"
  }
}

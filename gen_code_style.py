#!/usr/bin/python
#
# This is file is used to genrate the styles and codes for Demos
#
#
#
import sys
import re

file_list=[
    'AndroidManifest.xml',
    'res/values/themes.xml',
    'res/values/styles.xml',
    'res/layout/action_bar_movable_layout.xml',
    'src/java/com/example/miui/app/actionbar/ActionBarTitleDemo.java',
    'src/java/com/example/miui/app/actionbar/ActionBarTabDemo.java',
    'src/java/com/example/miui/app/actionbar/ActionBarSplitBarDemo.java',
    'src/java/com/example/miui/app/actionbar/ActionBarTabs.java',
    'src/java/com/example/miui/app/actionbar/ActionBarMovableLayoutDemo.java',
    'src/java/com/example/miui/app/actionbar/EditActionModeDemo.java',
    'src/java/com/example/miui/app/actionbar/SearchActionModeDemo.java',
    'src/java/com/example/miui/app/AlertDialogDemo.java'
]

out_file='src/java/com/example/miui/CodeStyles.java'

PatternBegin = re.compile(r".*CODE-BEGIN[ ]+([A-Za-z_][A-Za-z0-9_]*)")
PatternEnd = re.compile(r".*CODE-END[ ]+([A-Za-z_][A-Za-z0-9_]*)")

tables={}

def addText(name, text):
    if tables.has_key(name):
        tables[name] = tables[name] + text
    else:
        tables[name] = text

class ParseState:
    def __init__(self, name, line):
        self.name = name
        self.texts = []
        len_strip = len(line) - len(line.lstrip())
        self.strips = ""
        if len_strip > 0: self.strips = line[:len_strip]
    def add(self, line):
        if self.strips and len(self.strips) and line.startswith(self.strips):
            line = line[len(self.strips):]
        self.texts.append(line[:-1])


def parseFile(filename):
    f = open(filename, 'r')
    try:
        name =  ""
        strips = ""
        list_info = []
        for line in f:
                m = PatternBegin.match(line)
                if m:
                    name = m.group(1)
                    state = 1 #get data
                    ps = ParseState(name, line)
                    list_info.append(ps)
                else:
                    m = PatternEnd.match(line)
                    if m:
                        end_name = m.group(1)
                        if end_name == name: #end
                            ps = list_info[-1]
                            addText(ps.name, ps.texts)
                            list_info = list_info[:-1]
                            if len(list_info) > 0:
                                name = list_info[-1].name
                    else:
                        for ps in list_info:
                            ps.add(line)

        if len(list_info) > 0:
            for ps in list_info:
                addText(ps.name, ps.texts)
    finally:
        f.close()


for filename in file_list:
    parseFile(filename)

# out file
output = open(out_file, "w")

output.write("""
/**
 * This file is auto generated, don't edit
 */

package com.example.miui;

public class CodeStyles {

""")


for (name,text) in tables.items():
    output.writelines("    public static final String " + name + " =\n")
    show_add = False
    for l in text:
        l = l.replace("\\", "\\\\")
        l = l.replace("\"", "\\\"")
        if show_add:
            output.write("        + \"" + l + "\\n\"\n")
        else:
            output.write("        \"" + l + "\\n\"\n")
            show_add = True
    output.write("    ;\n\n");

output.write("""
}
""")


# Classwork
A repo to store all classwork. classes I'm currently in will stay in their own repo, but once Im done I'll merge them to here

# How to merge

take everything from the class ( project-a), and put it into a folder called CS###_ClassName ( don't forget .gitignore and readme)

Merge `project-a` into `project-b` ( from [stackoverflow](https://stackoverflow.com/questions/1425892/how-do-you-merge-two-git-repositories) )
```
cd path/to/project-b
git remote add project-a /path/to/project-a
git fetch project-a --tags
git merge --allow-unrelated-histories project-a/master # or whichever branch you want to merge
git remote remove project-a
```

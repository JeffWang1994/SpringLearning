# Git高端操作
    写一下关于Git的语法笔记，不要直接使用GitHub Desktop, 这样可以使自己假装像是一个 很高端的程序员，只用命令行～

## Git流程介绍
    首先Git是一个好东西，而且是一个很简单的东西。个人理解，这就是个丢球问题。
    有三个篮子，干活的篮子叫做Workspace, 本地仓库叫做Repository, 远程仓库叫做Remote. 
    那么丢球运动就是：
        1. Repository<--->Remote: --->叫push(推上去), <---叫fetch/clone(最常用)
        2. Workspace<--->Repository: --->叫commit(提交), <---叫checkout(检查)
        3. Remote--->workspace: --->叫pull(拉下来)

## 新建库
    git init[project-name] # 新建一个名叫project-name的仓库
    git clone [url] # 直接复制别人的仓库到本地仓库

## 配置(虽然平时用不到，但是第一次要配置用户名和邮箱)
    git config --list # 显示当前的Git配置
    git config -e [--global] # 编辑配置文件
    git config [--global] user.name "[name]"
    git config [--global] user.email "[email address]"

## 提交(Commit)
    git commit -m [message] # 普通提交
    git commit -a(ll) # 全提交(约等于普通提交)
    git commit -v(iew) # 可视化提交(提交时看看提交了些啥)

## 远程同步(pull & push)
    git fetch [remote] # 下载远程仓库中的变动, clone是复制文件，fetch是下载Diff
    git remote -v(iew) # 显示所有远程仓库
    git pull [remote] [branch] # 下拉远程仓库的变化到本地仓库的分支branch中
    git push [remote] [branch] # 推送本地仓库的变化到远程仓库的分支branch中
    git push [remote] --force # 暴力推送，有可能文件有冲突，但不管，直接推。

## 分支(branch)
    git branch [branch-name] # 建立新分支，用于写新代码，又不破坏原代码。
    git checkour -b [branch] # 新建分支，并切换到新分支。
    git merge [branch] # 合并分支，感觉写的可以了，就合并。
    git branch -d [branch-name] # 删除分支。

## 查看历史(log)
    git status # 显示变更文件
    git log # 显示当前分支的版本历史
    git log -s [keyword] # 关键词搜索
    git log --pretty --oneline # 显示过去5次提交
    git blame [file] # 显示指定文件是什么人在什么时间修改过
    
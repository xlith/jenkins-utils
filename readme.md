# Jenkins Shared Library

This is a Jenkins shared library repository. It contains groovy utility functions to be used when automating actions in Jenkins

This readme provides information on how to configure Jenkins and how to use these functions inside Jenkins pipeline scripts.

## Configuration

Using Jenkins shared library repository is easy. No external plugin or configuration is required. Jenkins core has a dedicated configuration option to enable shared library repository.

## Enable shared library repository globally

- Go to:
  - `HOME > Manage Jenkins (Configuration) > Global Pipeline Libraries`
- Configure the library by adding the following details:
  - `Name`
    - Name of the shared library repository i.e `git-utils`
    - Later this name will be used to reference the shared library repository in Jenkins pipeline scripts.
  - `Default version`
    - Input `master` here. We will be using only one version of shared library repository and it will be always be on master branch.
  - `Load implicitly`
    - Don't enable this option. This is a global configuration option and it will be enabled by default. We will include the library that we need in the pipeline script.
  - `Allow default version to be overridden`
    - Don't enable this option. We will only use one version of shared library repository and it will be always be latest version.
  - `Include @Library changes in job recent changes`
    - Don't enable this option. We don't want to include changes in shared library repository in the builds.
  - `Cache fetched versions on controller for quick retrieval`
    - Select `git`Don't enable this option.
  - `Retrieval method`
    - Select `Modern SCM`
  - `Source Code Management`
    - Select `Git`
  - `Project Repository`
    - Input repository address. In this case `ssh://git@git.office.comscore.com/tag/jenkins-shared-library.git`
  - `Credentials`
    - Select the appropriate credentials that has access to the repository.
  - `Discover branches`
    - Leave as default.
  - `Library Path (optional)`
    - This is important. We will be using this path to include the library in the pipeline script. This repo has multiple libraries and directory needs to be specified. i.e if you want to include `git-utils` library then you need to specify the path as `git-utils`.

## Enable shared library repository in a specific folder

- Goto:
  - `FOLDER > Configure > Pipeline Libraries`
- Rest of the configuration is same as above.

## Using shared library repository in a pipeline script

- Add the library functions to the pipeline script:

  - ```groovy
    library 'git-utils'

    pipeline{
    ...

    ```

- Use the functions inside `steps` block:

  - ```groovy
    steps {
        ...
        sshagent(credentials : ['gitserver-credentials']) {
            mergeBranches("main", "develop")
        }
        ...
    }
    ```

## Repository Structure

Inside the repository there are multiple folders. Each folder contains a library. Name of the folder is used when configuring the Jenkins. (When configuring using the same folder and library name will make it easier to match up the library.)

Each library has multiple functions inside `vars` folder. (This folder must be named `vars`)

Each file in the vars directory is a function. The name of the file is the name of the function. The file contains the function code. The function code is written in Groovy. 

In order to add a new function to the library, create a new file in the `vars` folder. Use unique function/file names to avoid conflicts.

```sh
./
├── file-utils/ # Library name
│  └── vars/    # The directory where functions are grouped
│     └── copyFolderToSharedDrive.groovy    # Function name
├── git-utils/  # Library name
│  └── vars/    # The directory where functions are grouped
│     ├── commitAll.groovy                  # Function name
│     ├── configureGit.groovy               # Function name
│     ├── createTag.groovy                  # Function name
│     ├── gitCreateTagCommitPush.groovy     # Function name
│     └── resetDevelopToMaster.groovy       # Function name
└── readme.md
```

## Function Code Structure

Each file must contain the following structure:

- File must begin with the following code:

  - ```groovy
    #!/usr/bin/env groovy
    ```

- File must include a function named `call`. This function will be called by the pipeline script and will be executed automatically.:

  - ```groovy
    def call(arg1, arg2, ...) {
        ...
    }
    ```

## More Information

<https://www.jenkins.io/doc/book/pipeline/shared-libraries/>

#!/usr/bin/env groovy

def call(String git_local_branch, String build_ticket_id, String new_version) {
  print_git_diff()
  commit_all(build_ticket_id, "Updates files with new build version ${new_version}")
  merge_onto_with_commit(git_local_branch, 'master', build_ticket_id, "New build ready version ${new_version}")
  create_tag(new_version, build_ticket_id, "New build ready version ${new_version}")
}
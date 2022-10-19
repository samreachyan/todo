ARG TOKEN=not-set

RUN apt-get update && apt-get install -y curl libgtk-dotnet3.0-cil

ENV RUNNER_ALLOW_RUNASROOT=1

RUN curl -o actions-runner-linux-x64-2.298.2.tar.gz -L https://github.com/actions/runner/releases/download/v2.298.2/actions-runner-linux-x64-2.298.2.tar.gz && \
    tar xzf ./actions-runner-linux-x64-2.298.2.tar.gz

RUN ./config.sh --url https://github.com/samreachyan/todo --token $TOKEN --name linux --work _work --runasservice --disableupdate

CMD ["./run.sh"]

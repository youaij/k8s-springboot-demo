package com.example.k8s.demo;

import io.fabric8.kubernetes.api.model.PodList;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;


@EnableKubernetesMockClient
public class ClientTest {
    KubernetesClient client;

    @Test
    public void testClientConnetct() throws IOException {
        InputStream resourceAsStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("my-tke.yaml");
        String config = IOUtils.toString(resourceAsStream, "utf-8");
        Config kubeconfig = Config.fromKubeconfig(config);
        DefaultKubernetesClient client = new DefaultKubernetesClient(kubeconfig);
        //READ
        PodList ns1 = client.pods().inNamespace("default").list();
        System.out.println(Arrays.asList(ns1));
    }

}

/*
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.vision.v1.spring;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.CredentialsProvider;
import com.google.api.gax.core.ExecutorProvider;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.HeaderProvider;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.cloud.spring.core.DefaultCredentialsProvider;
import com.google.cloud.vision.v1.ImageAnnotatorClient;
import com.google.cloud.vision.v1.ImageAnnotatorSettings;
import java.io.IOException;
import java.util.Collections;
import javax.annotation.Generated;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Auto-configuration for {@link ImageAnnotatorClient}.
 *
 * <p>Provides auto-configuration for Spring Boot
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default transport provider is used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 */
@Generated("by google-cloud-spring-generator")
@BetaApi("Autogenerated Spring autoconfiguration is not yet stable")
@AutoConfiguration
@ConditionalOnClass(ImageAnnotatorClient.class)
@ConditionalOnProperty(
    value = "com.google.cloud.vision.v1.spring.auto.image-annotator.enabled",
    matchIfMissing = true)
@EnableConfigurationProperties(ImageAnnotatorSpringProperties.class)
public class ImageAnnotatorSpringAutoConfiguration {
  private final ImageAnnotatorSpringProperties clientProperties;
  private final CredentialsProvider credentialsProvider;
  private static final Log LOGGER = LogFactory.getLog(ImageAnnotatorSpringAutoConfiguration.class);

  protected ImageAnnotatorSpringAutoConfiguration(
      ImageAnnotatorSpringProperties clientProperties, CredentialsProvider credentialsProvider)
      throws IOException {
    this.clientProperties = clientProperties;
    if (this.clientProperties.getCredentials().hasKey()) {
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Using credentials from ImageAnnotator-specific configuration");
      }
      this.credentialsProvider =
          ((CredentialsProvider) new DefaultCredentialsProvider(this.clientProperties));
    } else {
      this.credentialsProvider = credentialsProvider;
    }
  }

  /**
   * Returns the default channel provider. The default is gRPC and will default to it unless the
   * useRest option is provided to use HTTP transport instead
   */
  @Bean
  @ConditionalOnMissingBean
  public TransportChannelProvider defaultImageAnnotatorTransportChannelProvider() {
    return ImageAnnotatorSettings.defaultTransportChannelProvider();
  }

  /**
   * Provides a ImageAnnotatorClient bean configured to use the default credentials provider
   * (obtained with imageAnnotatorCredentials()) and its default transport channel provider
   * (defaultImageAnnotatorTransportChannelProvider()). It also configures the quota project ID if
   * provided. It will configure an executor provider in case there is more than one thread
   * configured in the client
   *
   * <p>Individual retry settings are configured as well. It will use the relevant client library's
   * default retry settings when they are not specified in ImageAnnotatorSpringProperties.
   */
  @Bean
  @ConditionalOnMissingBean
  public ImageAnnotatorClient imageAnnotatorClient(
      @Qualifier("defaultImageAnnotatorTransportChannelProvider")
          TransportChannelProvider defaultTransportChannelProvider)
      throws IOException {
    ImageAnnotatorSettings.Builder clientSettingsBuilder =
        ImageAnnotatorSettings.newBuilder()
            .setCredentialsProvider(this.credentialsProvider)
            .setTransportChannelProvider(defaultTransportChannelProvider)
            .setHeaderProvider(this.userAgentHeaderProvider());
    if (this.clientProperties.getQuotaProjectId() != null) {
      clientSettingsBuilder.setQuotaProjectId(this.clientProperties.getQuotaProjectId());
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Quota project id set to "
                + this.clientProperties.getQuotaProjectId()
                + ", this overrides project id from credentials.");
      }
    }
    if (this.clientProperties.getExecutorThreadCount() != null) {
      ExecutorProvider executorProvider =
          ImageAnnotatorSettings.defaultExecutorProviderBuilder()
              .setExecutorThreadCount(this.clientProperties.getExecutorThreadCount())
              .build();
      clientSettingsBuilder.setBackgroundExecutorProvider(executorProvider);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Background executor thread count is "
                + this.clientProperties.getExecutorThreadCount());
      }
    }
    if (this.clientProperties.getUseRest()) {
      clientSettingsBuilder.setTransportChannelProvider(
          ImageAnnotatorSettings.defaultHttpJsonTransportProviderBuilder().build());
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Using HTTP transport channel");
      }
    }
    RetrySettings.Builder batchAnnotateImagesRetrySettingBuilder =
        clientSettingsBuilder.batchAnnotateImagesSettings().getRetrySettings().toBuilder();
    if (this.clientProperties.getBatchAnnotateImagesInitialRetryDelay() != null) {
      batchAnnotateImagesRetrySettingBuilder.setInitialRetryDelay(
          this.clientProperties.getBatchAnnotateImagesInitialRetryDelay());
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "BatchAnnotateImagesInitialRetryDelay set to "
                + this.clientProperties.getBatchAnnotateImagesInitialRetryDelay());
      }
    }
    if (this.clientProperties.getBatchAnnotateImagesRetryDelayMultiplier() != null) {
      batchAnnotateImagesRetrySettingBuilder.setRetryDelayMultiplier(
          this.clientProperties.getBatchAnnotateImagesRetryDelayMultiplier());
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "BatchAnnotateImagesRetryDelayMultiplier set to "
                + this.clientProperties.getBatchAnnotateImagesRetryDelayMultiplier());
      }
    }
    if (this.clientProperties.getBatchAnnotateImagesMaxRetryDelay() != null) {
      batchAnnotateImagesRetrySettingBuilder.setMaxRetryDelay(
          this.clientProperties.getBatchAnnotateImagesMaxRetryDelay());
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "BatchAnnotateImagesMaxRetryDelay set to "
                + this.clientProperties.getBatchAnnotateImagesMaxRetryDelay());
      }
    }
    if (this.clientProperties.getBatchAnnotateImagesInitialRpcTimeout() != null) {
      batchAnnotateImagesRetrySettingBuilder.setInitialRpcTimeout(
          this.clientProperties.getBatchAnnotateImagesInitialRpcTimeout());
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "BatchAnnotateImagesInitialRpcTimeout set to "
                + this.clientProperties.getBatchAnnotateImagesInitialRpcTimeout());
      }
    }
    if (this.clientProperties.getBatchAnnotateImagesRpcTimeoutMultiplier() != null) {
      batchAnnotateImagesRetrySettingBuilder.setRpcTimeoutMultiplier(
          this.clientProperties.getBatchAnnotateImagesRpcTimeoutMultiplier());
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "BatchAnnotateImagesRpcTimeoutMultiplier set to "
                + this.clientProperties.getBatchAnnotateImagesRpcTimeoutMultiplier());
      }
    }
    if (this.clientProperties.getBatchAnnotateImagesMaxRpcTimeout() != null) {
      batchAnnotateImagesRetrySettingBuilder.setMaxRpcTimeout(
          this.clientProperties.getBatchAnnotateImagesMaxRpcTimeout());
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "BatchAnnotateImagesMaxRpcTimeout set to "
                + this.clientProperties.getBatchAnnotateImagesMaxRpcTimeout());
      }
    }
    if (this.clientProperties.getBatchAnnotateImagesTotalTimeout() != null) {
      batchAnnotateImagesRetrySettingBuilder.setTotalTimeout(
          this.clientProperties.getBatchAnnotateImagesTotalTimeout());
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "BatchAnnotateImagesTotalTimeout set to "
                + this.clientProperties.getBatchAnnotateImagesTotalTimeout());
      }
    }
    clientSettingsBuilder
        .batchAnnotateImagesSettings()
        .setRetrySettings(batchAnnotateImagesRetrySettingBuilder.build());
    RetrySettings.Builder batchAnnotateFilesRetrySettingBuilder =
        clientSettingsBuilder.batchAnnotateFilesSettings().getRetrySettings().toBuilder();
    if (this.clientProperties.getBatchAnnotateFilesInitialRetryDelay() != null) {
      batchAnnotateFilesRetrySettingBuilder.setInitialRetryDelay(
          this.clientProperties.getBatchAnnotateFilesInitialRetryDelay());
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "BatchAnnotateFilesInitialRetryDelay set to "
                + this.clientProperties.getBatchAnnotateFilesInitialRetryDelay());
      }
    }
    if (this.clientProperties.getBatchAnnotateFilesRetryDelayMultiplier() != null) {
      batchAnnotateFilesRetrySettingBuilder.setRetryDelayMultiplier(
          this.clientProperties.getBatchAnnotateFilesRetryDelayMultiplier());
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "BatchAnnotateFilesRetryDelayMultiplier set to "
                + this.clientProperties.getBatchAnnotateFilesRetryDelayMultiplier());
      }
    }
    if (this.clientProperties.getBatchAnnotateFilesMaxRetryDelay() != null) {
      batchAnnotateFilesRetrySettingBuilder.setMaxRetryDelay(
          this.clientProperties.getBatchAnnotateFilesMaxRetryDelay());
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "BatchAnnotateFilesMaxRetryDelay set to "
                + this.clientProperties.getBatchAnnotateFilesMaxRetryDelay());
      }
    }
    if (this.clientProperties.getBatchAnnotateFilesInitialRpcTimeout() != null) {
      batchAnnotateFilesRetrySettingBuilder.setInitialRpcTimeout(
          this.clientProperties.getBatchAnnotateFilesInitialRpcTimeout());
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "BatchAnnotateFilesInitialRpcTimeout set to "
                + this.clientProperties.getBatchAnnotateFilesInitialRpcTimeout());
      }
    }
    if (this.clientProperties.getBatchAnnotateFilesRpcTimeoutMultiplier() != null) {
      batchAnnotateFilesRetrySettingBuilder.setRpcTimeoutMultiplier(
          this.clientProperties.getBatchAnnotateFilesRpcTimeoutMultiplier());
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "BatchAnnotateFilesRpcTimeoutMultiplier set to "
                + this.clientProperties.getBatchAnnotateFilesRpcTimeoutMultiplier());
      }
    }
    if (this.clientProperties.getBatchAnnotateFilesMaxRpcTimeout() != null) {
      batchAnnotateFilesRetrySettingBuilder.setMaxRpcTimeout(
          this.clientProperties.getBatchAnnotateFilesMaxRpcTimeout());
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "BatchAnnotateFilesMaxRpcTimeout set to "
                + this.clientProperties.getBatchAnnotateFilesMaxRpcTimeout());
      }
    }
    if (this.clientProperties.getBatchAnnotateFilesTotalTimeout() != null) {
      batchAnnotateFilesRetrySettingBuilder.setTotalTimeout(
          this.clientProperties.getBatchAnnotateFilesTotalTimeout());
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "BatchAnnotateFilesTotalTimeout set to "
                + this.clientProperties.getBatchAnnotateFilesTotalTimeout());
      }
    }
    clientSettingsBuilder
        .batchAnnotateFilesSettings()
        .setRetrySettings(batchAnnotateFilesRetrySettingBuilder.build());
    RetrySettings.Builder asyncBatchAnnotateImagesRetrySettingBuilder =
        clientSettingsBuilder.asyncBatchAnnotateImagesSettings().getRetrySettings().toBuilder();
    if (this.clientProperties.getAsyncBatchAnnotateImagesInitialRetryDelay() != null) {
      asyncBatchAnnotateImagesRetrySettingBuilder.setInitialRetryDelay(
          this.clientProperties.getAsyncBatchAnnotateImagesInitialRetryDelay());
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "AsyncBatchAnnotateImagesInitialRetryDelay set to "
                + this.clientProperties.getAsyncBatchAnnotateImagesInitialRetryDelay());
      }
    }
    if (this.clientProperties.getAsyncBatchAnnotateImagesRetryDelayMultiplier() != null) {
      asyncBatchAnnotateImagesRetrySettingBuilder.setRetryDelayMultiplier(
          this.clientProperties.getAsyncBatchAnnotateImagesRetryDelayMultiplier());
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "AsyncBatchAnnotateImagesRetryDelayMultiplier set to "
                + this.clientProperties.getAsyncBatchAnnotateImagesRetryDelayMultiplier());
      }
    }
    if (this.clientProperties.getAsyncBatchAnnotateImagesMaxRetryDelay() != null) {
      asyncBatchAnnotateImagesRetrySettingBuilder.setMaxRetryDelay(
          this.clientProperties.getAsyncBatchAnnotateImagesMaxRetryDelay());
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "AsyncBatchAnnotateImagesMaxRetryDelay set to "
                + this.clientProperties.getAsyncBatchAnnotateImagesMaxRetryDelay());
      }
    }
    if (this.clientProperties.getAsyncBatchAnnotateImagesInitialRpcTimeout() != null) {
      asyncBatchAnnotateImagesRetrySettingBuilder.setInitialRpcTimeout(
          this.clientProperties.getAsyncBatchAnnotateImagesInitialRpcTimeout());
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "AsyncBatchAnnotateImagesInitialRpcTimeout set to "
                + this.clientProperties.getAsyncBatchAnnotateImagesInitialRpcTimeout());
      }
    }
    if (this.clientProperties.getAsyncBatchAnnotateImagesRpcTimeoutMultiplier() != null) {
      asyncBatchAnnotateImagesRetrySettingBuilder.setRpcTimeoutMultiplier(
          this.clientProperties.getAsyncBatchAnnotateImagesRpcTimeoutMultiplier());
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "AsyncBatchAnnotateImagesRpcTimeoutMultiplier set to "
                + this.clientProperties.getAsyncBatchAnnotateImagesRpcTimeoutMultiplier());
      }
    }
    if (this.clientProperties.getAsyncBatchAnnotateImagesMaxRpcTimeout() != null) {
      asyncBatchAnnotateImagesRetrySettingBuilder.setMaxRpcTimeout(
          this.clientProperties.getAsyncBatchAnnotateImagesMaxRpcTimeout());
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "AsyncBatchAnnotateImagesMaxRpcTimeout set to "
                + this.clientProperties.getAsyncBatchAnnotateImagesMaxRpcTimeout());
      }
    }
    if (this.clientProperties.getAsyncBatchAnnotateImagesTotalTimeout() != null) {
      asyncBatchAnnotateImagesRetrySettingBuilder.setTotalTimeout(
          this.clientProperties.getAsyncBatchAnnotateImagesTotalTimeout());
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "AsyncBatchAnnotateImagesTotalTimeout set to "
                + this.clientProperties.getAsyncBatchAnnotateImagesTotalTimeout());
      }
    }
    clientSettingsBuilder
        .asyncBatchAnnotateImagesSettings()
        .setRetrySettings(asyncBatchAnnotateImagesRetrySettingBuilder.build());
    RetrySettings.Builder asyncBatchAnnotateFilesRetrySettingBuilder =
        clientSettingsBuilder.asyncBatchAnnotateFilesSettings().getRetrySettings().toBuilder();
    if (this.clientProperties.getAsyncBatchAnnotateFilesInitialRetryDelay() != null) {
      asyncBatchAnnotateFilesRetrySettingBuilder.setInitialRetryDelay(
          this.clientProperties.getAsyncBatchAnnotateFilesInitialRetryDelay());
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "AsyncBatchAnnotateFilesInitialRetryDelay set to "
                + this.clientProperties.getAsyncBatchAnnotateFilesInitialRetryDelay());
      }
    }
    if (this.clientProperties.getAsyncBatchAnnotateFilesRetryDelayMultiplier() != null) {
      asyncBatchAnnotateFilesRetrySettingBuilder.setRetryDelayMultiplier(
          this.clientProperties.getAsyncBatchAnnotateFilesRetryDelayMultiplier());
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "AsyncBatchAnnotateFilesRetryDelayMultiplier set to "
                + this.clientProperties.getAsyncBatchAnnotateFilesRetryDelayMultiplier());
      }
    }
    if (this.clientProperties.getAsyncBatchAnnotateFilesMaxRetryDelay() != null) {
      asyncBatchAnnotateFilesRetrySettingBuilder.setMaxRetryDelay(
          this.clientProperties.getAsyncBatchAnnotateFilesMaxRetryDelay());
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "AsyncBatchAnnotateFilesMaxRetryDelay set to "
                + this.clientProperties.getAsyncBatchAnnotateFilesMaxRetryDelay());
      }
    }
    if (this.clientProperties.getAsyncBatchAnnotateFilesInitialRpcTimeout() != null) {
      asyncBatchAnnotateFilesRetrySettingBuilder.setInitialRpcTimeout(
          this.clientProperties.getAsyncBatchAnnotateFilesInitialRpcTimeout());
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "AsyncBatchAnnotateFilesInitialRpcTimeout set to "
                + this.clientProperties.getAsyncBatchAnnotateFilesInitialRpcTimeout());
      }
    }
    if (this.clientProperties.getAsyncBatchAnnotateFilesRpcTimeoutMultiplier() != null) {
      asyncBatchAnnotateFilesRetrySettingBuilder.setRpcTimeoutMultiplier(
          this.clientProperties.getAsyncBatchAnnotateFilesRpcTimeoutMultiplier());
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "AsyncBatchAnnotateFilesRpcTimeoutMultiplier set to "
                + this.clientProperties.getAsyncBatchAnnotateFilesRpcTimeoutMultiplier());
      }
    }
    if (this.clientProperties.getAsyncBatchAnnotateFilesMaxRpcTimeout() != null) {
      asyncBatchAnnotateFilesRetrySettingBuilder.setMaxRpcTimeout(
          this.clientProperties.getAsyncBatchAnnotateFilesMaxRpcTimeout());
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "AsyncBatchAnnotateFilesMaxRpcTimeout set to "
                + this.clientProperties.getAsyncBatchAnnotateFilesMaxRpcTimeout());
      }
    }
    if (this.clientProperties.getAsyncBatchAnnotateFilesTotalTimeout() != null) {
      asyncBatchAnnotateFilesRetrySettingBuilder.setTotalTimeout(
          this.clientProperties.getAsyncBatchAnnotateFilesTotalTimeout());
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "AsyncBatchAnnotateFilesTotalTimeout set to "
                + this.clientProperties.getAsyncBatchAnnotateFilesTotalTimeout());
      }
    }
    clientSettingsBuilder
        .asyncBatchAnnotateFilesSettings()
        .setRetrySettings(asyncBatchAnnotateFilesRetrySettingBuilder.build());
    return ImageAnnotatorClient.create(clientSettingsBuilder.build());
  }

  private HeaderProvider userAgentHeaderProvider() {
    String springLibrary = "spring-autogen-image-annotator";
    String version = this.getClass().getPackage().getImplementationVersion();
    return () -> Collections.singletonMap("user-agent", springLibrary + "/" + version);
  }
}
/*
 * Copyright 2020 Google LLC. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.morldapp_demo01.posedetector;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.example.morldapp_demo01.GraphicOverlay;
import com.example.morldapp_demo01.GraphicOverlay.Graphic;
import com.google.mlkit.vision.common.PointF3D;
import com.google.mlkit.vision.pose.Pose;
import com.google.mlkit.vision.pose.PoseLandmark;

import java.util.List;

/** Draw the detected pose in preview. */
public class PoseGraphic extends Graphic {

  private static final float DOT_RADIUS = 8.0f;
  private static final float IN_FRAME_LIKELIHOOD_TEXT_SIZE = 30.0f;
  private static final float STROKE_WIDTH = 7.0f;
  private static final float POSE_CLASSIFICATION_TEXT_SIZE = 60.0f;

  private final Pose pose;
  private final boolean showInFrameLikelihood;
  private final boolean visualizeZ;
  private final boolean rescaleZForVisualization;
  private float zMin = Float.MAX_VALUE;
  private float zMax = Float.MIN_VALUE;

  private final boolean posedetectresult = false;

  private final List<String> poseClassification;

  private final Paint classificationTextPaint;
  private final Paint leftPaint;
  private final Paint rightPaint;
  private final Paint whitePaint;

  PoseGraphic(
          GraphicOverlay overlay,
          Pose pose,
          boolean showInFrameLikelihood,
          boolean visualizeZ,
          boolean rescaleZForVisualization,
          List<String> poseClassification) {
    super(overlay);
    this.pose = pose;
    this.showInFrameLikelihood = showInFrameLikelihood;
    this.visualizeZ = visualizeZ;
    this.rescaleZForVisualization = rescaleZForVisualization;

    this.poseClassification = poseClassification;
    classificationTextPaint = new Paint();
    classificationTextPaint.setColor(Color.WHITE);
    classificationTextPaint.setTextSize(POSE_CLASSIFICATION_TEXT_SIZE);
    classificationTextPaint.setShadowLayer(5.0f, 0f, 0f, Color.BLACK);

    whitePaint = new Paint();
    whitePaint.setStrokeWidth(STROKE_WIDTH);
    whitePaint.setColor(Color.WHITE);
    whitePaint.setTextSize(IN_FRAME_LIKELIHOOD_TEXT_SIZE);
    leftPaint = new Paint();
    leftPaint.setStrokeWidth(STROKE_WIDTH);
    leftPaint.setColor(Color.GREEN);
    rightPaint = new Paint();
    rightPaint.setStrokeWidth(STROKE_WIDTH);
    rightPaint.setColor(Color.YELLOW);
  }

  @Override
  public void draw(Canvas canvas) {
    List<PoseLandmark> landmarks = pose.getAllPoseLandmarks();
    if (landmarks.isEmpty()) {
      return;
    }
    else
    {
    }

    // Draw pose classification text.
//    float classificationX = POSE_CLASSIFICATION_TEXT_SIZE * 0.5f;
//    for (int i = 0; i < poseClassification.size(); i++) {
//      float classificationY =
//              (canvas.getHeight()
//                      - POSE_CLASSIFICATION_TEXT_SIZE * 1.5f * (poseClassification.size() - i));
//      canvas.drawText(
//              poseClassification.get(i), classificationX, classificationY, classificationTextPaint);
//    }

    // Draw all the points


    PoseLandmark nose = pose.getPoseLandmark(PoseLandmark.NOSE);
    PoseLandmark lefyEyeInner = pose.getPoseLandmark(PoseLandmark.LEFT_EYE_INNER);
    PoseLandmark lefyEye = pose.getPoseLandmark(PoseLandmark.LEFT_EYE);
    PoseLandmark leftEyeOuter = pose.getPoseLandmark(PoseLandmark.LEFT_EYE_OUTER);
    PoseLandmark rightEyeInner = pose.getPoseLandmark(PoseLandmark.RIGHT_EYE_INNER);
    PoseLandmark rightEye = pose.getPoseLandmark(PoseLandmark.RIGHT_EYE);
    PoseLandmark rightEyeOuter = pose.getPoseLandmark(PoseLandmark.RIGHT_EYE_OUTER);
    PoseLandmark leftEar = pose.getPoseLandmark(PoseLandmark.LEFT_EAR);
    PoseLandmark rightEar = pose.getPoseLandmark(PoseLandmark.RIGHT_EAR);
    PoseLandmark leftMouth = pose.getPoseLandmark(PoseLandmark.LEFT_MOUTH);
    PoseLandmark rightMouth = pose.getPoseLandmark(PoseLandmark.RIGHT_MOUTH);

    PoseLandmark leftShoulder = pose.getPoseLandmark(PoseLandmark.LEFT_SHOULDER);
    PoseLandmark rightShoulder = pose.getPoseLandmark(PoseLandmark.RIGHT_SHOULDER);
    PoseLandmark leftElbow = pose.getPoseLandmark(PoseLandmark.LEFT_ELBOW);
    PoseLandmark rightElbow = pose.getPoseLandmark(PoseLandmark.RIGHT_ELBOW);
    PoseLandmark leftWrist = pose.getPoseLandmark(PoseLandmark.LEFT_WRIST);
    PoseLandmark rightWrist = pose.getPoseLandmark(PoseLandmark.RIGHT_WRIST);
    PoseLandmark leftHip = pose.getPoseLandmark(PoseLandmark.LEFT_HIP);
    PoseLandmark rightHip = pose.getPoseLandmark(PoseLandmark.RIGHT_HIP);
    PoseLandmark leftKnee = pose.getPoseLandmark(PoseLandmark.LEFT_KNEE);
    PoseLandmark rightKnee = pose.getPoseLandmark(PoseLandmark.RIGHT_KNEE);
    PoseLandmark leftAnkle = pose.getPoseLandmark(PoseLandmark.LEFT_ANKLE);
    PoseLandmark rightAnkle = pose.getPoseLandmark(PoseLandmark.RIGHT_ANKLE);

    PoseLandmark leftPinky = pose.getPoseLandmark(PoseLandmark.LEFT_PINKY);
    PoseLandmark rightPinky = pose.getPoseLandmark(PoseLandmark.RIGHT_PINKY);
    PoseLandmark leftIndex = pose.getPoseLandmark(PoseLandmark.LEFT_INDEX);
    PoseLandmark rightIndex = pose.getPoseLandmark(PoseLandmark.RIGHT_INDEX);
    PoseLandmark leftThumb = pose.getPoseLandmark(PoseLandmark.LEFT_THUMB);
    PoseLandmark rightThumb = pose.getPoseLandmark(PoseLandmark.RIGHT_THUMB);
    PoseLandmark leftHeel = pose.getPoseLandmark(PoseLandmark.LEFT_HEEL);
    PoseLandmark rightHeel = pose.getPoseLandmark(PoseLandmark.RIGHT_HEEL);
    PoseLandmark leftFootIndex = pose.getPoseLandmark(PoseLandmark.LEFT_FOOT_INDEX);
    PoseLandmark rightFootIndex = pose.getPoseLandmark(PoseLandmark.RIGHT_FOOT_INDEX);

    // Face
    drawLine(canvas, nose, lefyEyeInner, whitePaint);
    drawLine(canvas, lefyEyeInner, lefyEye, whitePaint);
    drawLine(canvas, lefyEye, leftEyeOuter, whitePaint);
    drawLine(canvas, leftEyeOuter, leftEar, whitePaint);
    drawLine(canvas, nose, rightEyeInner, whitePaint);
    drawLine(canvas, rightEyeInner, rightEye, whitePaint);
    drawLine(canvas, rightEye, rightEyeOuter, whitePaint);
    drawLine(canvas, rightEyeOuter, rightEar, whitePaint);
    drawLine(canvas, leftMouth, rightMouth, whitePaint);

    drawLine(canvas, leftShoulder, rightShoulder, whitePaint);
    drawLine(canvas, leftHip, rightHip, whitePaint);

    // Left body
    drawLine(canvas, leftShoulder, leftElbow, whitePaint);
    drawLine(canvas, leftElbow, leftWrist, whitePaint);
    drawLine(canvas, leftShoulder, leftHip, whitePaint);
    drawLine(canvas, leftHip, leftKnee, whitePaint);
    drawLine(canvas, leftKnee, leftAnkle, whitePaint);
    drawLine(canvas, leftWrist, leftThumb, whitePaint);
    drawLine(canvas, leftWrist, leftPinky, whitePaint);
    drawLine(canvas, leftWrist, leftIndex, whitePaint);
    drawLine(canvas, leftIndex, leftPinky, whitePaint);
    drawLine(canvas, leftAnkle, leftHeel, whitePaint);
    drawLine(canvas, leftHeel, leftFootIndex, whitePaint);

    // Right body
    drawLine(canvas, rightShoulder, rightElbow, whitePaint);
    drawLine(canvas, rightElbow, rightWrist, whitePaint);
    drawLine(canvas, rightShoulder, rightHip, whitePaint);
    drawLine(canvas, rightHip, rightKnee, whitePaint);
    drawLine(canvas, rightKnee, rightAnkle, whitePaint);
    drawLine(canvas, rightWrist, rightThumb, whitePaint);
    drawLine(canvas, rightWrist, rightPinky, whitePaint);
    drawLine(canvas, rightWrist, rightIndex, whitePaint);
    drawLine(canvas, rightIndex, rightPinky, whitePaint);
    drawLine(canvas, rightAnkle, rightHeel, whitePaint);
    drawLine(canvas, rightHeel, rightFootIndex, whitePaint);

    drawPoint(canvas, rightShoulder, whitePaint);
    drawPoint(canvas, rightElbow, whitePaint);
    drawPoint(canvas, rightHip, whitePaint);
    drawPoint(canvas, rightHeel, whitePaint);
    drawPoint(canvas, rightKnee, whitePaint);

    drawPoint(canvas, leftShoulder, whitePaint);
    drawPoint(canvas, leftElbow, whitePaint);
    drawPoint(canvas, leftHip, whitePaint);
    drawPoint(canvas, leftHeel, whitePaint);
    drawPoint(canvas, leftKnee, whitePaint);




    // Draw inFrameLikelihood for all points
    if (showInFrameLikelihood) {

//      for (PoseLandmark landmark : landmarks) {
        //canvas.drawText(
        //String.format(Locale.US, "%.2f", landmark.getInFrameLikelihood()),
        //translateX(landmark.getPosition().x),
        //translateY(landmark.getPosition().y),
        //whitePaint);
//      }
    }
  }


  void drawPoint(Canvas canvas, PoseLandmark landmark, Paint paint) {
    PointF3D point = landmark.getPosition3D();
    //updatePaintColorByZValue(
    //       paint, canvas, visualizeZ, rescaleZForVisualization, point.getZ(), zMin, zMax);
    canvas.drawCircle(translateX(point.getX()), translateY(point.getY()), DOT_RADIUS, paint);
  }

  void drawLine(Canvas canvas, PoseLandmark startLandmark, PoseLandmark endLandmark, Paint paint) {
    PointF3D start = startLandmark.getPosition3D();
    PointF3D end = endLandmark.getPosition3D();

    // Gets average z for the current body line
    float avgZInImagePixel = (start.getZ() + end.getZ()) / 2;

    canvas.drawLine(
            translateX(start.getX()),
            translateY(start.getY()),
            translateX(end.getX()),
            translateY(end.getY()),
            paint);
  }
}

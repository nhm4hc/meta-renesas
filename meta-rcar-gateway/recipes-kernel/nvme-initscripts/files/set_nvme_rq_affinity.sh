#!/bin/sh

# Don't use same CPU for HW interrupt and SW read/write
echo 0 > /sys/block/nvme0n1/queue/rq_affinity
